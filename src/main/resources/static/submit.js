$( document ).ready(function() {
    $( "#submitButton" ).click(function() {
        let person = $("#person").val();
        let weapon = $("#weapon").val()
        let room = $("#rooms").val()

        $.post("/submit")
    });
});