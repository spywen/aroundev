/**
 * Created by Antonin on 10/01/2015.
 */
/**
 * Created by laurent on 07/11/14.
 */
angular.module('aroundev.events', [
    'aroundev.events.modal.new',
    'ui.bootstrap',
    'ui.router',
    'toastr',
    'aroundev.service.events',
    'aroundev.search'
])
    .config(function($stateProvider){
        $stateProvider.state('events', {
            url:'/events',
            templateUrl: '/app/js/modules/Events/view/events.html'

    });

    });

