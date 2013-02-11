$(document).ready(function() {
   initValidation();
   
   var competenceNum = 1, availabilityNum = 1;
   
   // Lägger in en bild på länkarna för att lägga till flera kompetenser/tillgängligheter
   $('.addLink').each(function() {
       $(this).html('<img src="resources/gfx/add-64.png" alt="Add Competence" width="20" height="20" />');
   });
   
   /**
    * Kompetensrader
    */
   var first = true;
   $('.competenceRow').each(function() {
     
     // Göm alla utom första raden
     if (!first) {
       $(this).hide();
     }
     else {
       first = false;
     }
   });
   
   // Vissa en gömd rad när man trycker på plustecknet
   $('#addCompetence').click(function(e) {
      e.preventDefault();
      
      $('.competenceRow').each(function() {
	if ($(this).css('display') == 'none') {
	  $(this).slideDown('fast');
	  competenceNum++;
	  return false;
	}
      });
      
      // Om antalet synliga rader är 10, göm plustecknet
      if (competenceNum == 10) {
	$(this).fadeOut('fast');
      }
   });
   
   /**
    * Tillgänglighetsrader
    */
   first = true;
   $('.availabilityRow').each(function() {
     
     // Göm alla utom första raden
     if (!first) {
       $(this).hide();
     }
     else {
       first = false;
     }
   });
   
   // Vissa en gömd rad när man trycker på plustecknet
   $('#addAvailability').click(function(e) {
      e.preventDefault();
      
      $('.availabilityRow').each(function() {
	if ($(this).css('display') == 'none') {
	  $(this).slideDown('fast');
	  availabilityNum++;
	  return false;
	}
      });
      
      // Om antalet synliga rader är 10, göm plustecknet
      if (availabilityNum == 10) {
	$(this).fadeOut('fast');
      }
   });
});

