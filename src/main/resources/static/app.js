const host = "http://localhost:8080";
const STATUSES = ["offen", "in_arbeit", "erledigt"];

window.onload = loadTasks;

function loadTasks() {
    fetch(`${host}/tasks`)
        .then(r => r.json())
        .then(renderTasks);
}

function renderTasks(tasks) {
    const table = document.getElementById("tasksTable");
    [...table.rows].slice(1).forEach(row => row.remove());

    tasks.forEach(task => {
        const row = table.insertRow();

        row.insertCell().textContent = task.name;
        row.insertCell().textContent = task.description;

        const statusCell = row.insertCell();
        const select = document.createElement("select");
        STATUSES.forEach(status => {
            const option = document.createElement("option");
            option.value = status;
            option.textContent = status;
            if (status === task.status) option.selected = true;
            select.appendChild(option);
        });
        select.onchange = () => updateStatus(task.name, select.value);
        statusCell.appendChild(select);

        const actionCell = row.insertCell();
        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.onclick = () => deleteTask(task.name);
        actionCell.appendChild(deleteButton);
    });
}

function addTask() {
    const name = document.getElementById("new-task-name").value.trim();
    const description = document.getElementById("new-task-description").value.trim();
    const status = document.getElementById("new-task-status").value;

    if (!name) return;

    fetch(`${host}/tasks/create-task`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ taskname: name, description: description, status: status })
    }).then(() => {
        document.getElementById("new-task-name").value = "";
        document.getElementById("new-task-description").value = "";
        loadTasks();
    });
}

function updateStatus(taskname, newStatus) {
    fetch(`${host}/tasks/${encodeURIComponent(taskname)}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newStatus)
    }).then(loadTasks);
}

function deleteTask(taskname) {
    fetch(`${host}/tasks/${encodeURIComponent(taskname)}`, {
        method: "DELETE"
    }).then(loadTasks);
}