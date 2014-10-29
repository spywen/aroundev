/**
 * Created by laurent on 24/10/14.
 */
angular.module('aroundev.service.security', [])
.service('securityService',function(user){

    this.hasRole = function(role){
        return !!_.find(user.value.roles, { name : role });
    };

});