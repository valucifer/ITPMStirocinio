/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

tpOrganizationFunction = {
    appendTraining: function (idPanel, account, path) {
        $.ajax({
            url: path + '/organizationGetAllTrainingOffers',
            dataType: 'text',
            data: {accountEmail:account},
            type: 'POST',
            success: function (e) {
                var parsed = jQuery.parseJSON(e);
                if(parsed.status==1){
                    /*$("#messageTrainingControl").attr("class","alert alert-success");
                    $("#messageTrainingControl").html("<strong>Eccellente, </strong>in tirocinio è stato inserito nel database.\n A breve apparirà nella lista");
                    setTimeout(function(){
                                    location.reload();
                            },5000);*/
                    var myArrayForListTraining = parsed.message;
                    for(var i = 0; i < myArrayForListTraining.length; i++){
                        var tmpIDTraining=myArrayForListTraining[i].id;
                        var tmpDescriptionTraining=myArrayForListTraining[i].description;
                        var stringToAppend_tmp = '<a href="#" class="list-group-item" onclick="return false;" style="cursor:default;">';
                        stringToAppend_tmp = stringToAppend_tmp + '<p id="paragraphDescriptionListTraining_'+tmpIDTraining+'" class="list-group-item-text">'+tmpDescriptionTraining+'</p><div class="vertical-top" align="right">';
                        stringToAppend_tmp = stringToAppend_tmp + '<button id="modifyListTraining_'+tmpIDTraining+'" class="btn btn-orange btn-sm" onclick=modifyTrainingToDatabase('+tmpIDTraining+')><i class="fa fa-pencil"></i><span> Modifica</span></button>';
                        stringToAppend_tmp = stringToAppend_tmp + '<button id="removeListTraining_'+tmpIDTraining+'" class="btn btn-red btn-sm" onclick=removeTrainingToDatabase('+tmpIDTraining+')><i class="fa fa-trash"></i><span> Elimina</span></button>';
                        stringToAppend_tmp = stringToAppend_tmp + '</div></a>';

                        $(idPanel).append(stringToAppend_tmp);
                    }
                }else{
                        $(idPanel).append("<center><strong>I dati non sono stati caricati correttamente o non sono presenti nel database.</strong></center>");
                }
            },error: function (e) {
                $(idPanel).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
            }
        });
        
    },
    deleteTraining: function (idTraining, path) {
        $.get(path+"/organizationDeleteTrainingOffer",{idRemove:idTraining}).done(function(e){
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