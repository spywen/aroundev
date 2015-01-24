/**
 * Created by Antonin on 10/01/2015.
 */
angular.module('aroundev.search', [
    "ngAnimate" ,
    'ui.bootstrap'

])


.directive('search',function(){
    return {
        // scope: true,
        restrict:'E',
        //controller:'searchCtrl',
        //replace:true,//IMPORTANT : solution found for modified dom by link method ->
        templateUrl:'/app/js/modules/search/search.html'
    };
    //compile : function ..., replace : true or false
})
    .controller('CollapseDemoCtrl', function ($scope) {
        $scope.isCollapsed = true;
    });