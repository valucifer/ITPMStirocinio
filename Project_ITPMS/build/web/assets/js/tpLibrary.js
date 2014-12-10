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
    createPendingStudentPanel:function(panelID){
        $(panelID).empty();
        $(panelID).append("<center><h2>Al momento la tua richiesta è stata inoltrata!</h2><h3>Attendi la risposta.</h3></center>");
    },
    createAcceptStudentPanel: function(panelID){
        $(panelID).empty();
        $(panelID).append("<center><h2>La tua richiesta è stata accettata!</h2><h3>Scegli l'azienda che ti schiavizzerà.</h3></center>");
    },
    createDefaultStudentPanel: function(panelID){
        var string_tmp = "<p>Questa sezione del sito ti permetterà di inoltrare una richiesta di tirocinio. Per inviare la tua richiesta, è necessario tu possieda un Curriculum Vitae e un documento sul quale vengono descritti esami effettuati, data di convalida e cfu ad essi associati.</p>";
            string_tmp = string_tmp + "<p>Entrambi i files devono essere in formato PDF e inviati all'Ufficio Amministrativo tramite i moduli sottostanti. L'ufficio amministrativo, in seguito, provvederà ad esaminare la tua richiesta e ti comunicherà su questa pagina l'esito della stessa.</p><br><br>";
            
            string_tmp = string_tmp + "<div class='row'><div class='col-sm-12'><div class='form-group'>";
            string_tmp = string_tmp + "<form role='form' class='form-horizontal' id='sendFilesForm' enctype='multipart/form-data'>";
            
            string_tmp = string_tmp + "<label class='col-sm-2 control-label' for='field-4' >Curriculum Vitae</label>";
            string_tmp = string_tmp + '<div class="col-sm-10"><input type="file" class="form-control" id="field-4" name="cv" accept="application/pdf"></div>';
            
            string_tmp = string_tmp + '<label class="col-sm-2 control-label" for="field-5">Esami svolti</label><br><br>';
            string_tmp = string_tmp + '<div class="col-sm-10"><input type="file" class="form-control" id="field-5" name="doc" accept="application/pdf"></div>';
            
            string_tmp = string_tmp + '<br><br><br><div id="filesControl" align="center"></div><div class="row"><center><span class="btn btn-success fileinput-button" id="sendFiles"><i class="fa-arrow-up"></i>';
            string_tmp = string_tmp + '<span>Invia Richiesta</span></span></center></div></form></div></div></div>';
            
            $(panelID).append(string_tmp);
    }
};

						