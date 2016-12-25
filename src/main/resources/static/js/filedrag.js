(function() {

	// getElementById
	function $id(id) {
		return document.getElementById(id);
	}

	// output information
	function Output(msg) {
		var m = $id("messages");
		m.innerHTML = msg + m.innerHTML;
	}

	// file drag hover
	function FileDragHover(e) {
		debugger;
		e.stopPropagation();
		e.preventDefault();
		e.target.className = (e.type == "dragover" ? "hover" : "");
	}

	// file selection
	function FileSelectHandler(e) {
		debugger;
		// cancel event and hover styling
		FileDragHover(e);

		// fetch FileList object
		var files = e.target.files || e.dataTransfer.files;

		// process all File objects
		for (var i = 0, f; f = files[i]; i++) {
			ParseFile(f, i);
			upload(i, f);
			debugger;
		}
		$("#fileselect")[0].value = '';
		$("#messages").find(":button").click(function() {
			debugger;
			$(this).parent().remove();
			var name = $(this).parent().find('.filename').text();
			$.ajax({
				url : '...',
				type : 'POST',
				processData : false,
				contentType : false,
				data : name,
				success : function(data, status, jqxhr) {
					// success code
				},
				error : function(jqxhr, status, msg) {
					// error code
				}
			});
		});

	}

	function upload(id, f) {
		var file = $('#fileselect')[0].files[id];
		debugger;
		var fd = new FormData();
		fd.append('name', "test")
		fd.append('file', file);
		$.ajax({
			url : 'http://localhost:8080/MediAssist/project/uploadMultipleFile',
			type : 'POST',
			processData : false,
			contentType : false,
			data : fd,
			success : function(data, status, jqxhr) {
				// ParseFile(f,id); //success code
			},
			error : function(jqxhr, status, msg) {
				// error code at expection control will come here
			}
		});
	}

	// output file information
	function ParseFile(file, id) {

		Output("<p>File information: <strong><span class='filename'>"
				+ file.name + "</span></strong> type: <strong>" + file.type
				+ "</strong> size: <strong>" + file.size
				+ "</strong> bytes <input type=button value='X' id='" + id
				+ "'/></p>");

	}

	// initialize
	function Init() {

		var fileselect = $id("fileselect"), filedrag = $id("filedrag"), submitbutton = $id("submitbutton");

		// file select
		fileselect.addEventListener("change", FileSelectHandler, false);

		// is XHR2 available?
		var xhr = new XMLHttpRequest();
		if (xhr.upload) {

			// file drop
			filedrag.addEventListener("dragover", FileDragHover, false);
			filedrag.addEventListener("dragleave", FileDragHover, false);
			filedrag.addEventListener("drop", FileSelectHandler, false);
			filedrag.style.display = "block";

			// remove submit button
			submitbutton.style.display = "none";
		}

	}

	// call initialization file
	if (window.File && window.FileList && window.FileReader) {
		Init();
	}

})();
