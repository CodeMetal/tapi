/**
 * Created by bhandr1 on 5/14/2016.
 */

(function () {

    angular
        .module('app.tapi')
        .service('TestSuiteConstant', TestSuiteConstant);
    
    TestSuiteConstant.$inject = [];
    
    function TestSuiteConstant(){
        var constant = this;
        
        constant.TESTCASE_BASIC_APP_URL_BASE="http://localhost:8095/testCase";
        constant.TESTSUITE_BASIC_APP_URL_BASE="http://localhost:8095/testSuite";
        
    }
    
})();
    
    