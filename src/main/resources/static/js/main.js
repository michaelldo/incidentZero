$(document).ready( function () {
  $('#incidents').DataTable({});

    $('.table .btn').on('click', function (){

    });
} );

document.querySelectorAll('.editItem').forEach(function(element, index) {
   element.addEventListener("click", function (){
       console.log(element.getAttribute("data-id"));

       const confirmModal = new bootstrap.Modal(document.getElementById('updateIncidentModal'));
       confirmModal.show();

       findById(element.getAttribute("data-id"));
   })
});
function findById(idIncident) {

        $.ajax({
            method: "GET",
            url: "incidentById/" + idIncident,
            success: function (response) {
                console.log(response)
                document.getElementById("nameUpdateField").value = response.name;
                document.getElementById("updateDescriptionField").value = response.descriptionIncident;
                document.getElementById("idIncidentUpdateField").value = response.idIncident
            }
        }).fail(function (xhr, status, errorThroew) {
            alert("Erro ao Buscar Incidente: " + xhr.responseText)
        });
}

document.querySelectorAll('.excludeItem').forEach(function(element, index) {
    element.addEventListener("click", function (){
        console.log(element.getAttribute("data-id"));

        const confirmModal = new bootstrap.Modal(document.getElementById('updateIncidentModal'));
        // confirmModal.show();

        deleteIncidenById(element.getAttribute("data-id"));
    })
});

function deleteIncidenById(idIncident){
    $.ajax({
        method: "DELETE",
        url: "deleteIncident/"+ idIncident,
        success: function (response) {
            alert(response);
            location.reload();
        }
    }).fail(function (xhr, status, errorThroew) {
        alert("Erro ao deletar Incidente: " + xhr.responseText)
    });
}
