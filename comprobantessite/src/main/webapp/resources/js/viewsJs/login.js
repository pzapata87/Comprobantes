var loginJs = function () {	
	var aplicarHandlers = function() {		
		$('#frmLogin').on('submit', function (e) {
			webApp.showLoading();
			return true;
	    });
	}
	
	return {
        //main function to initiate page
        init: function (parametros) {
        	aplicarHandlers();
        }
    };
}();