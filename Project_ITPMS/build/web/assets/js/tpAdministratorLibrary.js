/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

tpAdminFunction = {
    functionDownload: function (idStudent, typology, path) {
        this.downloadFile(idStudent, typology, path);
    },
    rejectTrainingRequest: function (count, email) {
        if ($("#esDocumentError").is(":checked")) {
            $("#esDocumentError").click();
        }
        if ($("#cfuNotFoundError").is(":checked")) {
            $("#cfuNotFoundError").click();
        }
        $("#textareaDescriptionError").val("");
        $("#serialNumberModalForReject").val(count);
        $("#errors").attr("value", count);
        $("#nameANDsurnameModalForReject").val(email);
        jQuery('#modal').modal('show', {backdrop: 'static'});
    },
    acceptTrainingRequest: function (idRequest, path) {
        this.acceptStudentForTraining(idRequest, path);
        setTimeout(function () {
            location.reload();
        }, 1000);
    },
    completeTrainingRequest: function (idComplete, path) {
        this.completeStudentForTraining(idComplete, path);
        alert("Lo studente " + idComplete + " ha concluso il tirocinio!");
        setTimeout(function () {
            location.reload();
        }, 1000);
    },
    appendStudentIntoSelectForChangeTraining: function (idComboStudent, path) {
        $.get(path + "/updateTrainingRequestStatus", {}).done(function (e) {
            var parsed = jQuery.parseJSON(e);
            if (parsed.status) {
                $(idComboStudent).empty();
                $(idComboStudent).append("<option value>---Select---</option>");
                var array = parsed.message;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].matricola + "'>Matr: " + array[i].matricola + ", Nome: " + array[i].credenziali + ", Titolo Tirocinio: " + array[i].titolo;
                    stringToAppend_tmp += "</option>";
                    $(idComboStudent).append(stringToAppend_tmp);
                }
            } else {
                $(idComboStudent).append("<option value='Dati_non_presenti'>Dati non presenti</option>");
            }
        }).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    },
    appendStudentTrainingComplete: function (idTable, path) {
        $.ajax({
            url: path + '/getStudentTrainingCompleteForTable',
            dataType: 'text',
            type: 'POST',
            success: function (e) {
                var parsed = jQuery.parseJSON(e);
                if (parsed.status) {
                    var array = parsed.message;
                    $(idTable + " tbody").empty();
                    for (var i = 0; i < array.length; i++) {
                        var stringToAppend_tmp = "";
                        stringToAppend_tmp = "<tr><td>";
                        stringToAppend_tmp += array[i].matricola + "</td><td>" + array[i].credenziali + "</td><td>";
                        stringToAppend_tmp += array[i].email + "</td><td>" + array[i].telefono + "</td><td>";
                        stringToAppend_tmp += array[i].titolo + "</td><td>" + array[i].azienda + "</td><td>";
                        stringToAppend_tmp += array[i].questionario + "</td></tr>";
                        stringToAppend_tmp += array[i].matricola;
                        $(idTable).append(stringToAppend_tmp);
                    }
                } else {
                    $(idTable).append("<tr><td></td><td></td><td></td><td>Non ci sono studenti tirocinanti.</td><td></td><td></td><td></td></tr>");
                }

                $(idTable).dataTable({
                    aLengthMenu: [
                        [10, 20, -1], [10, 20, "Tutti"]
                    ]});
            }, error: function (e) {
                $(idTable).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
            }
        });
    },
    downloadFile: function (matri, typo, path) {
        jQuery.ajax({
            url: path + "/downloadFile",
            type: "POST",
            data: {matricula: matri, typology: typo},
            success: function (data) {
                alert(JSON.stringify(data));
                window.location.href = data;
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert('Error ' + textStatus);
            }
        });
    },
    appendStudentInformation: function (idTable, path) {
        $.ajax({
            url: path + '/getStudentDetails',
            dataType: 'text',
            type: 'POST',
            success: function (e) {
                var parsed = jQuery.parseJSON(e);
                var array = parsed.message;
                $(idTable + " tbody").empty();
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<tr><td>" + array[i].matricula + "</td><td>" + array[i].credenziali;
                    stringToAppend_tmp += "</td><td>";
                    stringToAppend_tmp += "<button onClick=tpAdminFunction.functionDownload('" + array[i].idStudent + "','CV','"+path+"') class='btn btn-info btn-sm'><i class='fa fa-external-link'></i><span> Visualizza</span></button>";
                    stringToAppend_tmp += "</td><td>";
                    stringToAppend_tmp += "<button onClick=tpAdminFunction.functionDownload('" + array[i].idStudent + "','ES','"+path+"') class='btn btn-info btn-sm'><i class='fa fa-external-link'></i><span> Visualizza</span></button>";
                    stringToAppend_tmp += "</td><td>";
                    if (array[i].statusStudent !== 2) {
                        stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_' + array[i].idStudent + '"><button class="btn btn-sm btn-icon btn-secondary" onClick=tpAdminFunction.acceptTrainingRequest("' + array[i].idStudent + '","'+path+'")>Accetta</button>';
                        stringToAppend_tmp += "<button class='btn btn-sm btn-icon btn-red' onClick=tpAdminFunction.rejectTrainingRequest('" + array[i].idStudent + "','" + array[i].emailStudent + "')>Rifiuta</button></span></td></tr>";
                    } else {
                        stringToAppend_tmp += '<span id="changeRequestTrainingForComplete_' + array[i].idStudent + '"><button class="btn btn-sm btn-icon" onClick=tpAdminFunction.completeTrainingRequest("' + array[i].idStudent + '","'+path+'") style="background-color:#38548f; color:white;">Concluso</button></span></td></tr>';
                    }
                    $(idTable).append(stringToAppend_tmp);
                }
                $(idTable).dataTable({
                    aLengthMenu: [
                        [5, 10, 20, -1], [5, 10, 20, "Tutti"]
                    ],
                    "columnDefs": [
                        {"bSortable": false, "aTargets": [4]}
                    ]});
            }, error: function (e) {
                $(idTable).append("<center><strong>I dati non sono stati caricati correttamente.</strong></center>");
            }
        });
    },
    acceptStudentForTraining: function (idStudent, path) {
        $.post(path + "/acceptStudentForTraining", {matricula: idStudent}).done(function (e) {}).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    },
    completeStudentForTraining: function (idStudent, path) {
        $.get(path + "/completeTraining", {matricula: idStudent}).done(function (e) {}).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    },
    appendOrgANDProfessor: function (idComboOrg, idComboProf, path) {
        $.post(path + "/getAllOrganizations", {}).done(function (e) {
            var parsed = jQuery.parseJSON(e);
            if (parsed.status) {
                $(idComboOrg).empty();
                $(idComboOrg).append("<option value>---Select---</option>");
                var array = parsed.message;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].vatNumber + "'>" + array[i].companyName;
                    stringToAppend_tmp += "</option>";
                    $(idComboOrg).append(stringToAppend_tmp);
                }
            } else {
                $(idComboOrg).append("<option value>Dati non caricati</option>");
            }
        }).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
        $.post(path + "/getAllProfessors", {}).done(function (e) {
            var parsed = jQuery.parseJSON(e);
            if (parsed.status) {
                $(idComboProf).empty();
                $(idComboProf).append("<option value>---Select---</option>");
                var array = parsed.message;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].SSNProf + "'>" + array[i].NameANDSurname;
                    stringToAppend_tmp += "</option>";
                    $(idComboProf).append(stringToAppend_tmp);
                }
            } else {
                $(idComboProf).append("<option value>Dati non caricati</option>");
            }
        }).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    },
    appendProfessor: function (idComboProf, path) {
        $.post(path + "/getAllProfessors", {}).done(function (e) {
            var parsed = jQuery.parseJSON(e);
            if (parsed.status) {
                $(idComboProf).empty();
                $(idComboProf).append("<option value>---Select---</option>");
                var array = parsed.message;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].SSNProf + "'>" + array[i].NameANDSurname;
                    stringToAppend_tmp += "</option>";
                    $(idComboProf).append(stringToAppend_tmp);
                }
            } else {
                $(idComboProf).append("<option value>Dati non caricati</option>");
            }
        }).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    },
    appendAll: function (idComboOrga, idComboProf, idComboStud, path) {
        $.get(path + "/getAllEntities", {}).done(function (e) {
            var parsed = jQuery.parseJSON(e);
            if (parsed.status) {
                $(idComboProf).empty();
                $(idComboOrga).empty();
                $(idComboStud).empty();
                $(idComboOrga).append("<option value>---Select---</option>");
                var array = parsed.organization;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].vatNumber + "'>" + array[i].companyNa;
                    stringToAppend_tmp += "</option>";
                    $(idComboOrga).append(stringToAppend_tmp);
                }

                $(idComboProf).append("<option value>---Select---</option>");
                var array = parsed.professor;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].SSN + "'>" + array[i].credential;
                    stringToAppend_tmp += "</option>";
                    $(idComboProf).append(stringToAppend_tmp);
                }

                $(idComboStud).append("<option value>---Select---</option>");
                var array = parsed.student;
                for (var i = 0; i < array.length; i++) {
                    var stringToAppend_tmp = "";
                    stringToAppend_tmp = "<option value='" + array[i].SSNStudent + "'>" + array[i].credentialStudent;
                    stringToAppend_tmp += "</option>";
                    $(idComboStud).append(stringToAppend_tmp);
                }

            } else {
                $(idComboProf).append("<option value='null'>Dati non caricati</option>");
                $(idComboOrga).append("<option value='null'>Dati non caricati</option>");
                $(idComboStud).append("<option value='null'>Dati non caricati</option>");
            }
        }).fail(function (e) {
            alert("Si sono verificati dei problemi col server!");
        });
    }
};		