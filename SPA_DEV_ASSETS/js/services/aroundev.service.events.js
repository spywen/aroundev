/**
 * Created by laurent on 13/11/14.
 */
angular.module('aroundev.service.events', [
    'restangular'
])
.service('eventsService',function($translate, $http, $location, Restangular, $q, toastr, utilsService) {
    this.create = function(newEvent){
        return $q(function(resolve,reject){
            Restangular.one('api').post('events', newEvent).then(function(result){
                resolve(result);
            },function(){
                reject(false);
            });
        });
    };
    this.findAll = function(){
        return $q(function(resolve,reject){
            Restangular.one('api').one('events').get().then(function(result){
                resolve(result);
            },function(){
                reject(false);
            });
        });
    };

});