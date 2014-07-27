<%--
  Created by IntelliJ IDEA.
  User: laurent
  Date: 06/07/2014
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../include/header.jsp">
        <jsp:param name="title" value="Planning poker"/>
    </jsp:include>
<body>
    <jsp:include page="../menu.jsp"/>
    <div id="planningPoker" class="content" data-ng-app="planningPoker">
        <h1>Planning poker</h1>

        <div class="row">
            <div class="col-md-4" data-ng-controller="groomingsCtrl">
                <div class="panel panel-primary">
                    <div class="panel-heading">Grooming sessions</div>
                    <div class="panel-body">
                        <div>
                            <p>{{ groomings.length > 0 && groomings.length + ' active grooming(s)' || 'No grooming'}}</p>
                            <accordion close-others="oneAtATime">
                                <accordion-group data-ng-repeat="grooming in groomings" is-open="status.open">
                                    <accordion-heading>
                                        {{grooming.name}} <i class="pull-right fa" data-ng-class="{'fa-caret-down': status.open, 'fa-caret-right': !status.open}"></i>
                                    </accordion-heading>
                                    <p class="text-description">
                                        {{grooming.description}}
                                    </p>
                                    <a>URL</a>
                                </accordion-group>
                            </accordion>
                        </div>
                        <div class="panel panel-default newGroomingForm">
                            <div class="panel-body">
                                <div data-ng-show="!toggle">
                                    <button class="btn btn-primary btn-sm" data-ng-click="toggle = !toggle">New grooming session</button>
                                </div>
                                <div data-ng-show="toggle">
                                    <button class="btn btn-default btn-sm" data-ng-click="toggle = !toggle">Cancel</button>
                                    <form class="form-horizontal" role="form" data-ng-submit="newGroomingForm()">
                                        <input type="name" class="form-control" id="groomingName" placeholder="Name ..." data-ng-model="fields.name">
                                        <textarea class="form-control" rows="3" name="groomingDescription" placeholder="Description ..." data-ng-model="fields.description"></textarea>
                                        <input type="submit" value="Create" class="btn btn-primary btn-sm"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h3>Participants</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading">Stories</div>
                    <div class="panel-body">
                        <!--
                        <div class="panel panel-default cards">
                            <div class="panel-heading">Current story</div>
                            <div class="panel-body">
                                <div class="cardsChoose">
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                    <button class="btn btn-default">?</button>
                                </div>
                                <div class="cardsSelection">
                                    <button class="btn btn-primary">0</button>
                                    <button class="btn btn-primary">0.5</button>
                                    <button class="btn btn-primary">1</button>
                                    <button class="btn btn-primary">2</button>
                                    <button class="btn btn-primary">3</button>
                                    <button class="btn btn-primary">5</button>
                                    <button class="btn btn-primary">8</button>
                                    <button class="btn btn-primary">13</button>
                                    <button class="btn btn-primary">21</button>
                                    <button class="btn btn-primary">34</button>
                                </div>
                            </div>
                        </div>
                        -->
                    </div>
                </div>
            </div>
        </div>

    </div>

    <jsp:include page="../include/js.jsp"/>
</body>
</html>
