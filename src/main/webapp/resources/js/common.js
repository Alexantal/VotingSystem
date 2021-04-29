let failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(key, note) {
    new Noty({
        text: "<span class='fa fa-lg fa-check'></span> &nbsp;" + i18n[key] + "&nbsp;" + note,
        type: 'success',
        layout: "bottomRight",
        timeout: 2000
    }).show();
}