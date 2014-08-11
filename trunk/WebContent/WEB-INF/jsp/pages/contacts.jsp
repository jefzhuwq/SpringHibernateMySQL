<%@ include file="/WEB-INF/jsp/common.inc"%>

<link rel="stylesheet"
	href="http://static.jstree.com/3.0.2/assets/dist/themes/default/style.min.css" />

<script>
	$(function() {
		var availableTags = [ "ActionScript", "AppleScript", "Asp", "BASIC",
				"C", "C++", "Clojure", "COBOL", "ColdFusion", "Erlang",
				"Fortran", "Groovy", "Haskell", "Java", "JavaScript", "Lisp",
				"Perl", "PHP", "Python", "Ruby", "Scala", "Scheme" ];

		$("#tags").autocomplete({
			source : availableTags
		});

		
	$('#tree')
		.jstree(
				{
					"core" : {
						"animation" : 0,
						"check_callback" : true,
						"themes" : {
							"stripes" : true
						},
						'data' : {
							'url' : function(node) {
								return node.id === '#' ? '<c:url value="/json/ajax_demo_roots.json"/>'
										: '<c:url value="/json/ajax_demo_children.json"/>';
							},
							'data' : function(node) {
								return {
									'id' : node.id
								};
							}
						}
					},
					"types" : {
						"#" : {
							"max_children" : 1,
							"max_depth" : 4,
							"valid_children" : [ "root" ]
						},
						"root" : {
							"icon" : "./assets/images/tree_icon.png",
							"valid_children" : [ "default" ]
						},
						"default" : {
							"valid_children" : [ "default", "file" ]
						},
						"file" : {
							"icon" : "glyphicon glyphicon-file",
							"valid_children" : []
						}
					},
					"plugins" : [ "contextmenu", "dnd", "search",
							"state", "types", "wholerow" ]
				});
	
	$('.flexme1').flexigrid();
	});
	
	
</script>

<div class="container">
	<div class="container">
		<h2>Contacts</h2>
	</div>

	<div id="tree" style="width: 20%; float: left"></div>

	<div class="container" style="width: 80%; float: right">
		<a href="newcontact" class="ui-state-default ui-corner-all ui-state-hover">new</a>
		<input id="tags" class="ui-autocomplete-input">
		<button id="btnSearch" class="ui-state-default ui-corner-all ui-state-hover">Search</button>

		<div id="users-contain" >
			<table id="users" class="flexme1">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="contacts" items="${contacts}">
						<tr>
							<td>${contacts.id}</td>
							<td>test1</td>
							<td>test2</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>