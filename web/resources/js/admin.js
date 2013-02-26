$(document).ready(function() {
    var applicantSelected = false;
    $('.applicantRow').click(function() {
        
        $('#selectedName').text($(this).children('.name').text());
        $('#selectedSsn').text($(this).children('.ssn').text());
        $('#selectedEmail').text($(this).children('.email').text());
        $('#selectedCompetences').html($(this).find('.competence').html());
        $('#selectedAvailabilities').html($(this).find('.availability').html());
        
        if (!applicantSelected) {
            applicantSelected = true;
            $('#selectedApplicant').slideDown();
        }
    });
});
