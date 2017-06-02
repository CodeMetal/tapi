/**
 * Created by bhandr1 on 5/14/2016.
 */

(function () {

    angular
        .module('app.tapi')
        .service('TestCaseModel', TestCaseModel);

    function TestCaseModel(){
        var model = this;
       
        
        model.newTestCaseModel = function () {
        	return {
        		"scenarioName": "",
        		"scenarioDescription": "",
        		"endPointURI": "",
        		"endPointHost": "",
        		"endPointPort": "",
        		"requestMethod": "",
        		"responseType": ""
        	
        	};
        };

    }



})();