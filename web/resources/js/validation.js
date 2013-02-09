function initValidation() {
    // Regexps
    var nameTest = /[A-z -]+/g;
    var emailTest = /[A-z0-9.-_]+@[A-z0-9.-_]+.[A-z.-_]+/g
    var ssnTest = /[0-9]{10}/g;
    var compTest = /[0-9]*.?[0-9]*/g;
    var availTest = /[0-9]{4}-[0-9]{2}-[0-9]{2}/g;

    $('.submitButton').click(function(e) {
       var surname = $('.surname').val()
       var fname = $('.name').val()
       var email = $('.email').val()
       var ssn = $('.ssn').val()

       // Efternamn
       nameTest.lastIndex = 0;  // Reseta ifall det använts tidigare
       if (!nameTest.test(surname)) {
           $('.surnameRow .errorColumn').fadeIn();
           e.preventDefault();
       }
       
       // Förnamn
       nameTest.lastIndex = 0;  // Reseta ifall det använts tidigare
       if (!nameTest.test(fname)) {
           $('.fnameRow .errorColumn').fadeIn();
           e.preventDefault();
       }

       // Email
       emailTest.lastIndex = 0;  // Reseta ifall det använts tidigare
       if (!emailTest.test(email)) {
           $('.emailRow .errorColumn').fadeIn();
           e.preventDefault();
       }
       
       // Personnummer
       ssnTest.lastIndex = 0;  // Reseta ifall det använts tidigare
       if (!ssnTest.test(ssn)) {
           $('.ssnRow .errorColumn').fadeIn();
           e.preventDefault();
       }
       
       // Kompetens
       $('.competenceRow').each(function() {
           var row = $(this);
           if (row.css('display') != 'none') {
               $(this).children('input').each(function(){
                   compTest.lastIndex = 0;  // Reseta ifall det använts tidigare
                   var text = $(this).val();
                   if (!compTest.test(text)) {
                       row.children('.errorDiv').fadeIn();
                       e.preventDefault();
                   }
               });
           }
       });
       
       // TIllgänglighet
       $('.availabilityRow').each(function() {
          var row = $(this);
          if (row.css('display') != 'none') {
              $(this).children('input').each(function(ix) {
                availTest.lastIndex = 0;  // Reseta ifall det använts tidigare
                var text = $(this).val();
                if (!availTest.test(text)) {
                   row.children('.errorDiv').fadeIn();
                    e.preventDefault();
                }
              });
          } 
       });
    });
}
