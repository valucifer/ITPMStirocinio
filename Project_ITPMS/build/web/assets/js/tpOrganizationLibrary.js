/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

tpOrganizationFunction = {
    appendTraining: function (idPanel, path) {
        $.ajax({
            url: path + '/selectTrainingByOrganization',
            dataType: 'text',
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
                        $(idPanel).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
                }
            },error: function (e) {
                alert(JSON.stringify(e));
            }
        });
        
    }
};		