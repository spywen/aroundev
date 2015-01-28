/**
 * Created by laurent on 07/11/14.
 */
angular.module('aroundev.events', [
    'aroundev.events.modal.new',
    'ui.bootstrap',
    'ui.router',
    'toastr',
    'aroundev.service.events'
])
.config(function($stateProvider){
    $stateProvider.state('events', {
        url:'/events',
        templateUrl: 'events.html',
        controller: 'eventsCtrl',
        hasRoles:['AUTHENTICATED'],
        hasNotRoles:[]
    });
}).controller('eventsCtrl',function($scope, $modal, eventsService, toastr, $translate){
    $scope.oneAtATime = true;
    $scope.events = [];

    eventsService.findAll().then(function(result){
        $scope.events = result;
    },function(){
        toastr.error($translate.instant('COMMON_ERROR'));
        return false;
    });

    $scope.openNewEventModal = function () {

        $modal.open({
            templateUrl: 'newEventModal.html',
            controller: 'newEventModalCtrl'
        }).result.then(function () {
            //created
            eventsService.findAll().then(function(result){
                $scope.events = result;
            },function(){
                toastr.error($translate.instant('COMMON_ERROR'));
                return false;
            });
        }, function () {
            //cancel
        });

    };
});