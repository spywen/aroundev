/**
 * Created by laurent on 02/11/14.
 */
angular.module('aroundev.service.utils', [])
.service('utilsService',function(){

    this.errorMessage = {
        containMoreThanOne_Parameters : 'More than one of parameters are not an array'
    };

    this.containMoreThanOne = function(baseObjectsList, searchedObjects){

        //Checks validity
        if(!_.isArray(baseObjectsList) || !_.isArray(searchedObjects)){
            return this.errorMessage.containMoreThanOne_Parameters;
        }

        var found = false;
        _.forEach(searchedObjects, function(oneSearchedObject){
            if(_.contains(baseObjectsList, oneSearchedObject)){
                found = true;
            }
        });
        return found;
    };

});