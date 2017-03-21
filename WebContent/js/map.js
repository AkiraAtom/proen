var directionsDisplay;
	var directionsService;
	var map;
	var marker = new Array();

	function initialize() {

		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsService = new google.maps.DirectionsService();

		var latlng = new google.maps.LatLng(35.6894875, 139.6917064);
		var opts = {
			zoom : 13,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById("map_canvas"), opts);
		directionsDisplay.setMap(map);
		///////
		var marker = new google.maps.Marker({//マーカー
			map : map,
			position : new google.maps.LatLng(35.675660, 139.762888),//マーカーの場所
			animation : google.maps.Animation.DROP,
		});
		//マーカーを表示
		var marker1 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.690096, 139.684052),
			animation : google.maps.Animation.DROP,
		});

		var marker2 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.709192, 139.751648),
			animation : google.maps.Animation.DROP,
		});
		var marker3 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.707112, 139.773835),
			animation : google.maps.Animation.DROP,
		});
		var marker4 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.695548, 139.792182),
			animation : google.maps.Animation.DROP,
		});
		var marker5 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.727265, 139.770689),
			animation : google.maps.Animation.DROP,
		});
		var marker6 = new google.maps.Marker({
			map : map,
			position : new google.maps.LatLng(35.682489, 139.763413),
			animation : google.maps.Animation.DROP,
		});
		//////
		if (document.GPS.shopAddress.value == "") {
			document.GPS.GoGoodsJsp.disabled = true;
		} else {
			document.GPS.GoGoodsJsp.disabled = false;
		}

	}

	function initialize2() {

		directionsDisplay = new google.maps.DirectionsRenderer();
		directionsService = new google.maps.DirectionsService();

		var latlng = new google.maps.LatLng(35.6894875, 139.6917064);
		var opts = {
			zoom : 13,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		map = new google.maps.Map(document.getElementById("map_canvas"), opts);
		directionsDisplay.setMap(map);

		search2();
	}

	function dia() {
		navigator.geolocation.getCurrentPosition(successCallback,
				errorCallback, {
					maximumAge : 3000,
					timeout : 5000,
					enableHighAccuracy : true
				});
	}

	function dia2() {
		navigator.geolocation.getCurrentPosition(successCallback,
				errorCallback, {
					maximumAge : 3000,
					timeout : 5000,
					enableHighAccuracy : true
				});
		setTimeout('search2();', 1500);
	}

	function successCallback(p) {

		$("*[name=lat]").val(p.coords.latitude);
		$("*[name=lon]").val(p.coords.longitude);

		var geocoder = new google.maps.Geocoder();
		var latlng = new google.maps.LatLng(p.coords.latitude,
				p.coords.longitude);

		geocoder.geocode({
			latLng : latlng
		}, function(res, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				$("*[name=address]").val(res[0].formatted_address);
			}
		});

		if (marker[0] != null) {
			marker[0].setMap(null);
		}
		marker[0] = new google.maps.Marker({
			position : latlng,
			map : map
		});

		map.panTo(latlng);

	}

	function errorCallback(e) {
		alert('現在地を取得できません');
	}

	function search2() {
		if (marker[1] != null) {
			marker[1].setMap(null);
		}

		var geocoder = new google.maps.Geocoder();
		var latlng = document.forms.GPS.shopAddress.value;
		var origin1 = new google.maps.LatLng(document.forms.GPS.lat.value,
				document.forms.GPS.lon.value);

		geocoder.geocode({
			address : latlng
		}, function(res, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				$("*[name=lat2]").val(res[0].geometry.location.lat());
				$("*[name=lon2]").val(res[0].geometry.location.lng());
				var origin2 = new google.maps.LatLng(res[0].geometry.location
						.lat(), res[0].geometry.location.lng());

				if (marker[0] != null) {
					var service = new google.maps.DistanceMatrixService();
					service.getDistanceMatrix({
						origins : [ origin1 ],
						destinations : [ origin2 ],
						travelMode : google.maps.TravelMode.WALKING,
						avoidHighways : false,
						avoidTolls : false
					}, callback);

					marker[1] = new google.maps.Marker({
						position : origin2,
						map : map
					});

					var request = {
						origin : origin1,
						destination : origin2,
						travelMode : google.maps.TravelMode.WALKING
					};
					directionsService.route(request,
							function(response, status) {
								if (status == google.maps.DirectionsStatus.OK) {
									directionsDisplay.setDirections(response);
								}
							});

					var minX = marker[0].getPosition().lng();
					var minY = marker[0].getPosition().lat();
					var maxX = marker[0].getPosition().lng();
					;
					var maxY = marker[0].getPosition().lat();
					;
					for (var i = 0; i < 2; i++) {
						var lt = marker[i].getPosition().lat();
						var lg = marker[i].getPosition().lng();
						if (lg <= minX) {
							minX = lg;
						}
						if (lg > maxX) {
							maxX = lg;
						}
						if (lt <= minY) {
							minY = lt;
						}
						if (lt > maxY) {
							maxY = lt;
						}
					}
					var sw = new google.maps.LatLng(maxY, minX);
					var ne = new google.maps.LatLng(minY, maxX);
					var bounds = new google.maps.LatLngBounds(sw, ne);
					map.fitBounds(bounds);
				}

				if (marker[0] == null) {
					marker[1] = new google.maps.Marker({
						position : origin2,
						map : map
					});
					map.panTo(origin2);
					$("*[name=duration]").val("");
					$("*[name=distance]").val("");
					document.getElementById("duration").innerHTML = "";

				}
			} else if (status != google.maps.GeocoderStatus.OK) {
				if (marker[0] != null) {
					map.panTo(origin1);
				}
				directionsDisplay.setMap(null);
				directionsDisplay.setPanel(null);
				directionsDisplay = new google.maps.DirectionsRenderer();
				directionsDisplay.setMap(map);
				$("*[name=lat2]").val("");
				$("*[name=lon2]").val("");
				$("*[name=duration]").val("");
				$("*[name=distance]").val("");
				document.getElementById("duration").innerHTML = "";

			}
		});

		if (document.GPS.shopAddress.value == "") {
			document.GPS.GoGoodsJsp.disabled = true;
		}

		else {
			document.GPS.GoGoodsJsp.disabled = false;
		}
	}

	function callback(response, status) {

		if (status == google.maps.DistanceMatrixStatus.OK) {
			var origins = response.originAddresses;
			var destinations = response.destinationAddresses;

			for (var i = 0; i < origins.length; i++) {
				var results = response.rows[i].elements;
				for (var j = 0; j < results.length; j++) {
					var element = results[j];
					var distance = element.distance.text;
					var duration = element.duration.text;
					var from = origins[i];
					var to = destinations[j];

					$("*[name=duration]").val(duration);
					$("*[name=distance]").val(distance);
					document.getElementById("duration").innerHTML = duration;

				}
			}
		}
	}
	
	
	
	
	
	function To() {
		myform.mytext.value = "東京駐輪場";
	}
	function Sh() {
		myform.mytext.value = "新橋駐輪場";
	}
	function Shina() {
		myform.mytext.value = "品川駐輪場";
	}


	var yyyymmddhhmiss = function() {
		var date = new Date();
		var yyyy = date.getFullYear();
		var mm = toDoubleDigits(date.getMonth() + 1);
		var dd = toDoubleDigits(date.getDate() + 1);
		var hh = toDoubleDigits(date.getHours());
		var mi = toDoubleDigits(date.getMinutes());
		var ss = toDoubleDigits(date.getSeconds())
		var element = document.getElementById("date");
		element.innerHTML = yyyy + '/' + mm + '/' + dd;
	};
	var toDoubleDigits = function(num) {
		num += "";
		if (num.length === 1) {
			num = "0" + num;
		}
		return num;
	};

	setInterval(yyyymmddhhmiss, 1000);

	var yyyymmddhhmiss1 = function() {
		var date1 = new Date();
		var yyyy1 = date1.getFullYear();
		var mm1 = toDoubleDigits(date1.getMonth() + 1);
		var dd1 = toDoubleDigits(date1.getDate() + 2);
		var element1 = document.getElementById("date1");
		element1.innerHTML = yyyy1 + '/' + mm1 + '/' + dd1;
	};

	var toDoubleDigits1 = function(num) {
		num += "";
		if (num.length === 1) {
			num = "0" + num;
		}
		return num;
	};

	setInterval(yyyymmddhhmiss1, 1000);

	var yyyymmddhhmiss2 = function() {
		var date2 = new Date();
		var yyyy2 = date2.getFullYear();
		var mm2 = toDoubleDigits(date2.getMonth() + 1);
		var dd2 = toDoubleDigits(date2.getDate() + 3);
		var element2 = document.getElementById("date2");
		element2.innerHTML = yyyy2 + '/' + mm2 + '/' + dd2;
	};

	var toDoubleDigits2 = function(num) {
		num += "";
		if (num.length === 1) {
			num = "0" + num;
		}
		return num;
	};

	setInterval(yyyymmddhhmiss2, 1000);