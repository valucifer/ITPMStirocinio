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
                if(parsed.status==1){
                    for(var i = 0; i < array.length; i++){
                        var stringToAppend_tmp = "";
                        stringToAppend_tmp = "<tr><td>"+array[i].matricula+"</td><td>"+array[i].credenziali;
                        stringToAppend_tmp += "</td><td><a href='"+array[i].curriculum;
                        
                        stringToAppend_tmp += "' target='_blank'>";
                        stringToAppend_tmp += "<button class='btn btn-info btn-sm'><i class='fa fa-pencil'></i><span> Visualizza</span></button>"; 
                        
                        stringToAppend_tmp += "</a></td><td><a href='"+array[i].libretto;                   
                        stringToAppend_tmp += "' target='_blank'>";
                        stringToAppend_tmp += "<button class='btn btn-info btn-sm'><i class='fa fa-pencil'></i><span> Visualizza</span></button>"; 
                        
                        stringToAppend_tmp += "</a></td><td><td>";
                                           
                        if(array[i].statusStudent != 2){   
                            stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_'+i+'"><button id="accept_'+i+'" class="btn btn-sm btn-icon btn-secondary" onClick=acceptTrainingRequest('+i+')>Accetta</button>';
                            stringToAppend_tmp += "<button id='reject_"+i+"' class='btn btn-sm btn-icon btn-red' onClick=rejectTrainingRequest("+i+")>Rifiuta</button></span></td></tr>";
                        }else{
                            stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_'+i+'"><button id="complete_'+i+'" class="btn btn-sm btn-icon" onClick=completeTrainingRequest('+i+') style="background-color:#38548f; color:white;">Concluso</button></span></td></tr>';
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
                }else{
                        $(idTable).append("<center><strong>I dati non sono stati caricati correttamente o non sono presenti nel database.</strong></center>");
                }
            },error: function (e) {
                $(idTable).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
            }
        });
        
    },
    deleteTraining: function (idTraining, path) {
        $.get(path+"/deleteTrainingOfferByOrganizationServlet",{idRemove:idTraining}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                alert("Il tirocinio è stato eliminato!");
            }else{
                alert("Il tirocinio non è stato eliminato in quanto si sono verificati dei problemi!");          
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
    },
    updateTraining: function (idTraining, description, path) {
        $.get(path+"/deleteTrainingOfferByOrganizationServlet",{idModify:idTraining, description:description}).done(function(e){
            var parsed = jQuery.parseJSON(e);
            if(parsed.status==1){
                alert("Il tirocinio è stato modificato!");
            }else{
                alert("Il tirocinio non è stato modificato in quanto si sono verificati dei problemi!");          
            }
        }).fail(function(e){
            alert("Si sono verificati dei problemi col server!"); 
        });
    }
};		