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
.service('authService',function($translate, $http, $location, Restangular, $q, user, toastr){

    this.login = function(login,password){
        return $q(function(resolve, reject){
            Restangular.one('login').customPOST("login="+login+"&password="+password, undefined, undefined, {'Content-Type': 'application/x-www-form-urlencoded'}).then(function(){
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

    this.getProfile = function(){
        return $q(function(resolve, reject){
            if(_.isNull(user) || (_.isNull(user.roles))){
                Restangular.one('api/user/currentProfil').get().then(function(result){
                    user = {username: result.login, roles:result.roles};
                    resolve(result);
                },function(){
                    user = {username: '', roles:null};
                    reject(false);
                });
            }else{
                resolve(user);
            }
        });
    };

    this.hasRole = function(role){
        var that = this;
        return $q(function(resolve, reject){
            if(!_.isNull(user)){
                resolve(!!_.find(user.roles, { name : role }));
            }else{
                that.getProfile().then(function(){
                    resolve(!!_.find(user.roles, { name : role }));
                },function(){
                    reject(false);
                });
            }
        });
    };

    this.isAuthenticated = function(){
        var that = this;
        return $q(function(resolve, reject){
            that.hasRole('AUTHENTICATED').then(function(result){
                resolve(result);
            },function(){
                reject(false);
            });
        }, this);
    };

});