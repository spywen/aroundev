/**
 * Created by laurent on 19/10/2014.
 */
angular.module('aroundev.service.auth', [
    'pascalprecht.translate',
    'restangular'
])
.config(function(RestangularProvider){
    //RestangularProvider.setBaseUrl('/api/user/');
})
.service('authService',function($translate, $http, $location, Restangular, $q, user){

    this.login = function(login,password){
        return $q(function(resolve, reject){
            var data = {
                "login": login,
                "password": password
            };
            var dataEncoded = $.param(data);
            Restangular.one('login').customPOST(dataEncoded, undefined, undefined, {'Content-Type': 'application/x-www-form-urlencoded'}).then(function(){
                resolve(true);
            },function(){
                reject(false);
            });
        });
    };

    this.logout = function(){
        return $q(function(resolve, reject){
            Restangular.one('logout').get().then(function(){
                window.location.reload();
                resolve(result);
            }, function(){
                toastr.error($translate.instant('LOGIN_LOG_OUT_FAILED'));
                reject(false);
            });
        });
    };

    this.getProfil = function(){
        return $q(function(resolve, reject){
            Restangular.one('api/user/currentProfil').get().then(function(result){
                user.value = {username: result.login, roles:result.roles};
                resolve(result);
            },function(){
                reject(false);
            });
        });
    };

});