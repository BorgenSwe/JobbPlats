function initValidation() {
    // Regexps - FYLL I COOLA EXPRESSIONS!
    var nameTest = new RegExp("");
    var emailTest = new RegExp("");
    var ssnTest = new RegExp("");

    $('.submitButton').click(function(e) {
       var surname = $('.surname').val()
       var fname = $('.name').val()
       var email = $('.email').val()
       var ssn = $('.ssn').val()

       // Efternamn
       if (!nameTest.test(surname)) {
           alert("FAIL: surname");
           e.preventDefault();
       }
       
       // Förnamn
       if (!nameTest.test(fname)) {
           alert("FAIL: fname");
           e.preventDefault();
       }

       // Email
       if (!emailTest.test(email)) {
           alert("FAIL: EMAIL");
           e.preventDefault();
       }
       
       // Personnummer
       if (!ssnTest.test(ssn)) {
           alert("FAIL: ssn");
           e.preventDefault();
       }
    });
}
