const container = document.querySelector(".container");

function getMessages() {
    fetch(`http://localhost:8000/messages`)
        .then(function(response) {
            return response.json();
        })
        .then(function(messages) {
            innerMessages(messages)
    })
}

function innerMessages(messages) {
    let table = document.createElement("table");
    table.innerHTML =  "<tr><th>TITLE</th><th>CONTENT</th><th>AUTHOR</th><th>DATA CREATION</th><</tr>";
    container.appendChild(table);

    messages.forEach(message => {
        let row = document.createElement("tr");
        row.innerHTML = `
        <td>${message.title}</td>
        <td>${message.content}</td>
        <td>${message.authorName}</td>
        <td>${message.creationDate}</td>
        `;
        table.appendChild(row);
    });
}

getMessages();