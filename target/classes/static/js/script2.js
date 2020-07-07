const form = document.querySelector("#message-form");

form.addEventListener("submit", function(e) {
    e.preventDefault();


    const data = `title=${this.title.value}&content=${this.content.value}&author=${this.firstname.value}}`;
    setMessage(data);
});

function setMessage(data) {
    fetch(`http://${window.location.hostname}:${window.location.port}/guestbook_form`,
        {
            method: "POST",
            body: data,
            mode: "no-cors"
        })
        .then(function(response){
            console.log(response);
        });
}