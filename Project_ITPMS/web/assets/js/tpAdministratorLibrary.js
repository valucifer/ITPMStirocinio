/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

tpAdminFunction = {
    appendStudentInformation: function (idTable, path) {
        $.ajax({
            url: path + '/studentAttDetailsServlet',
            dataType: 'text',
            type: 'POST',
            success: function (e) {
                var parsed = jQuery.parseJSON(e);
                var array = parsed.message;
                    $(idTable+" tbody").empty();
                    for(var i = 0; i < array.length; i++){
                        var stringToAppend_tmp = "";
                        stringToAppend_tmp = "<tr><td>"+array[i].matricula+"</td><td>"+array[i].credenziali;
                        stringToAppend_tmp += "</td><td><a href='"+array[i].curriculum;
                        
                        stringToAppend_tmp += "' target='_blank'>";
                        stringToAppend_tmp += "<button class='btn btn-info btn-sm'><i class='fa fa-pencil'></i><span> Visualizza</span></button>"; 
                        
                        stringToAppend_tmp += "</a></td><td><a href='"+array[i].libretto;                   
                        stringToAppend_tmp += "' target='_blank'>";
                        stringToAppend_tmp += "<button class='btn btn-info btn-sm'><i class='fa fa-pencil'></i><span> Visualizza</span></button>"; 
                        
                        stringToAppend_tmp += "</a></td><td>";
                                           
                        if(array[i].statusStudent != 2){   
                            stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_'+array[i].idStudent+'"><button class="btn btn-sm btn-icon btn-secondary" onClick=acceptTrainingRequest("'+array[i].idStudent+'","'+array[i].emailStudent+'")>Accetta</button>';
                            stringToAppend_tmp += "<button class='btn btn-sm btn-icon btn-red' onClick=rejectTrainingRequest('"+array[i].idStudent+"','"+array[i].emailStudent+"')>Rifiuta</button></span></td></tr>";
                        }else{
                            stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_'+array[i].idStudent+'"><button class="btn btn-sm btn-icon" onClick=completeTrainingRequest("'+array[i].idStudent+'","'+array[i].emailStudent+'") style="background-color:#38548f; color:white;">Concluso</button></span></td></tr>';
                        }
                        $(idTable).append(stringToAppend_tmp);
                    }
                    $(idTable).dataTable({
                        aLengthMenu: [
                            [5, 10, 20, -1], [5, 10, 20, "Tutti"]
                        ],
                        "columnDefs": [
                            { "bSortable": false, "aTargets": [ 4 ] }
                    ]});
            },error: function (e) {
                $(idTable).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
            }
        });
        
    },
    acceptStudentForTraining: function (idStudent, path) {
        $.get(path+"/acceptStudentForTraining",{matricula:idStudent}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                alert("Lo studente può effettuare il tirocinio!");
            }else{
                alert("Lo studente non può effettuare il tirocinio!");          
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
    },
    appendOrgANDProfessor: function (idComboOrg, idComboProf, path) {
        $.get(path+"/viewAllOrganizationServlet",{}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                $(idComboOrg).empty();
                $(idComboOrg).append("<option value='none'>---Select---</option>");
                var array = parsed.message;
                for(var i = 0; i < array.length; i++){
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='"+array[i].vatNumber+"'>"+array[i].companyName;
                    stringToAppend_tmp += "</option>";
                    $(idComboOrg).append(stringToAppend_tmp);
                }
            }else{
                 $(idComboOrg).append("<option value='null'>Dati non caricati</option>");       
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
        $.get(path+"/viewAllProfessor",{}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                $(idComboProf).empty();
                $(idComboProf).append("<option value='none'>---Select---</option>");
                var array = parsed.message;
                for(var i = 0; i < array.length; i++){
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='"+array[i].SSNProf+"'>"+array[i].NameANDSurname;
                    stringToAppend_tmp += "</option>";
                    $(idComboProf).append(stringToAppend_tmp);
                }
            }else{
                 $(idComboProf).append("<option value='null'>Dati non caricati</option>");       
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
    },
    appendProfessor: function (idComboProf, path) {
        $.get(path+"/viewAllProfessor",{}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                $(idComboProf).empty();
                $(idComboProf).append("<option value='none'>---Select---</option>");
                var array = parsed.message;
                for(var i = 0; i < array.length; i++){
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='"+array[i].SSNProf+"'>"+array[i].NameANDSurname;
                    stringToAppend_tmp += "</option>";
                    $(idComboProf).append(stringToAppend_tmp);
                }
            }else{
                 $(idComboProf).append("<option value='null'>Dati non caricati</option>");       
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
    }
};		