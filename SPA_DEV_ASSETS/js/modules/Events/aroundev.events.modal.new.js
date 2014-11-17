/**
 * Created by laurent on 07/11/14.
 */
angular.module('aroundev.events.modal.new', [
    'ui.bootstrap',
    'aroundev.service.events'
]).controller('newEventModalCtrl',function($scope, $modalInstance, eventsService, toastr, $translate){
    $scope.create = function (event) {
        $scope.createEventLoading = true;
        var newEvent = angular.copy(event);
        newEvent.startdate = new Date(event.startdate).getTime();
        eventsService.create(newEvent).then(function(){
            $scope.createEventLoading = false;
            $modalInstance.close();
        }, function(){
            $scope.createEventLoading = false;
            toastr.error($translate.instant('COMMON_ERROR'));
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };
});