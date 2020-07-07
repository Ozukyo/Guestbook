const container = document.querySelector(".container");

function getMessages() {
    fetch(`http://${window.location.hostname}:${window.location.port}/messages`) //ten url zwraca nam array liste skonwertowana do jsona
        .then(function (response) {
            return response.json();
        })
        .then(function (messages) {
            innerMessages(messages);
        })
}

function innerMessages(messages) {
    let messageCards = document.createElement("messageCards");
    container.appendChild(messageCards);
    console.log(messages);

    messages.forEach(message => {
        let textMessage = document.createElement("message");
        let titleMessage = document.createElement("messagetitle");
        titleMessage.innerText = message.title;
        let contentMessage = document.createElement("messageContent");
        contentMessage.innerText = message.content;
        let author = document.createElement("author");
        author.innerText = message.authorName;
        let date = document.createElement("date");
        date.innerText = message.creationDate;

        textMessage.appendChild(titleMessage);
        textMessage.appendChild(author);
        textMessage.appendChild(date);
        textMessage.appendChild(contentMessage);
        messageCards.appendChild(textMessage);

    });


}


getMessages();