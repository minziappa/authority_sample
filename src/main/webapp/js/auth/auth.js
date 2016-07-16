function exceptionKey(e) {
    if(e.keyCode==37 || e.keyCode==38 || e.keyCode==39 || e.keyCode==40) {
    	
        return false;    	
    }
    return true;
}

function isEmpty(str) {
    return (!str || 0 === str.length);
}

function isBlank(str) {
    return (!str || /^\s*$/.test(str));
}

var timeout;
function interverKeystroke(e, num) {
	clearTimeout(timeout);
	timeout = setTimeout(function() {
	  console.log("You stopped typing.");
	  autoSearch(e, num);
	}, 500);
}

var ajaxLastNum = 0;

function autoSearch(e, num) {

	if(!exceptionKey(e)) {
		return false;
	}

	$(document).ready(function() {

		var $inputAname = $('form').find('input[name=aname]:eq(' + num + ')');

		if($inputAname.val().length < 2) {
			return false;
		}

		$inputAname.popover('destroy');
		var availableTags = [];
		var currentAjaxNum = ajaxLastNum;

        $.ajax({
            type: 'POST',
            url: 'http://localhost:9001/auth/searchUsersAjax',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            data: 'body={ "text" : "' + $inputAname.val() + '"}',
            cache: false,
            beforeSend: function(xhr, settings) {

            	ajaxLastNum = ajaxLastNum + 1;

            	$('#search' + num).removeClass('input-search');
            	$('#search' + num).addClass('input-spinner');
            },
            success: function(data, textStatus, request) {

            	$('#search' + num).removeClass('input-spinner');
            	$('#search' + num).addClass('input-search');

            	if(currentAjaxNum == ajaxLastNum - 1) {
                	
                	if(!isBlank(data.users)) {
                		console.log(data.users);
                		availableTags = data.users;
                		$('#statuses').html('<li>' + data.users + '</li>');
                	}
                	var availableNames = [];

                	for (var i in availableTags) {
                		availableNames[i] = availableTags[i].map1;
                	}
                	
                	console.log(availableNames);

                	$inputAname.autocomplete();

                    // Close if already visible
                	if ($inputAname.autocomplete("widget").is(":visible")) {
                		$inputAname.autocomplete("close");
                		return false;
                	}

                	$inputAname.autocomplete({source: availableTags, 
                		autoFocus: true, 
                		minLength: 0,
                		create: function( event, ui ) {
                			console.log(" create >> ");
                		    if($(this).autocomplete('widget').is(':visible')) {
                		    	console.log(" create >> visible");
                		    } else {
                		    	console.log(" create >> desable");
                		    }
                			return true;
                		},
                		close: function( event, ui ) {
                			console.log(" close >> desable");
                		},
                		open: function( event, ui ) {
                			console.log(" open >> ");
                			return true;
                		},
                		search: function( event, ui ) {
                			console.log(" search >> ");
                			return true;
                		},
                		focus: function( event, ui ) {
                			console.log(" focus >> " + ui.item.value);
                			$inputAname.val( ui.item.name );
                			// $(this).autocomplete("search");
                			return false;
                		},
                		select: function( event, ui ) {
                			console.log(" select >> " + ui.item.map1);
                			$inputAname.val( ui.item.map1 );
                			return false;
                		}
                	})
                	.data( "ui-autocomplete" )._renderItem = function( ul, item ) {
                        return $( "<li>" ).attr( "data-value", item.map1 )
                        .append( item.map1 + ", " + item.map2 + '<img id="img1" src="/img/icon.jpg" height="80" width="80">' )
                        .appendTo( ul );
                    };

    	            // fire search event
                	$inputAname.autocomplete("search", "");
                	$inputAname.focus();

            	}

            },
            complete: function(xhr, textStatus) {
            	//$inputAname.attr('disabled', false);


            },
            error: function(xhr, status) {
            	console.log(xhr.responseText);
            	//alert(xhr.responseText);
            }
        });

	    console.log("4");
	});
}
