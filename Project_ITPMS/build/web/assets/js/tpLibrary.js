/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 
 (function( $ ){
 $.fn.createStudentPendingPanel = function(panelBody) {
 $(panelBody).append("Studente in attesa...");
 return this;
 }; 
 })( jQuery );
 
 */

tpFunction = {
    createPendingStudentPanel: function (panelID) {
        $(panelID).empty();
        $(panelID).append("<center><h2>La tua richiesta è stata inoltrata!</h2><br><h4>Il personale amministrativo sta visionando la tua richiesta. Riceverai al più presto aggiornamenti sullo stato della pratica.</h4></center>");
    },
    createAcceptStudentPanel: function (panelID) {
        $(panelID).empty();
        $(panelID).append("<center><h2>La tua richiesta è stata <strong>accettata</strong>!</h2><br><h4>Puoi ora procedere a reperire le informazioni dei referenti responsabili del tirocinio.</h4></center>");
    },
    populateTable: function (idTable, tableContainer, path) {
        $.ajax({
            url: path + '/viewAllTrainingOffer',
            dataType: 'text',
            type: 'POST',
            success: function (e) {
                $(idTable).append('<thead><tr><th>Nome Azienda</th><th>Professore Associato</th><th>Descrizione</th><th>Contatti</th></tr></thead>');
                var parsed = JSON.parse(e);
                if (!parsed.status)
                    return;
                var jsonObj = parsed.message;
                var tmp = '';
                for (var i = 0; i < jsonObj.length; i++) {
                    tmp += '<tr><td>' + jsonObj[i].organization + '</td><td>' + jsonObj[i].professor + '</td><td>' + jsonObj[i].description + '</td><td>' + jsonObj[i].contacts + '</td><td></tr>';
                }
                $(idTable).append(tmp);
                $(idTable).dataTable({
                    aLengthMenu: [
                        [5, 10, 20, -1], [5, 10, 20, "Tutti"]
                    ]});
                $(tableContainer).attr("hidden", false);
            },
            error: function (e) {
                alert(JSON.stringify(e));
            }
        });


    }
};

						