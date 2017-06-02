/**
 * Created by bhandr1 on 5/14/2016.
 */
(function () {
    angular.module('app.tapi').factory('TestCaseBasicFactory',TestCaseBasicFactory);

    TestCaseBasicFactory.$inject = ["RestHelper","TestSuiteConstant"];

    function TestCaseBasicFactory(RestHelper,TestSuiteConstant) {

        return {
            createTestCaseData: createTestCaseData,
            getAllTestCases: getAllTestCases
        };

       
       
        
        function createTestCaseData(data){
        	return RestHelper.post("",TestSuiteConstant.TESTCASE_BASIC_APP_URL_BASE,data);
        }
        
        function getAllTestCases(){
        	return RestHelper.get("",TestSuiteConstant.TESTCASE_BASIC_APP_URL_BASE + "/list");
        }


    }
})();
