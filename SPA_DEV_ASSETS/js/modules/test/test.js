/**
 * Created by laurent on 12/01/15.
 */
angular.module('aroundev.test', [
    'ui.router'
])
.config(function($stateProvider){
    $stateProvider.state('test', {
        url:'/test',
        templateUrl: '/app/js/modules/test/view/test.html'
    });
}).directive('testDirective',function(){
    return {
        scope: true,
        restrict:'E',
        templateUrl:'/app/js/modules/test/view/testDirective.html'
    };
});