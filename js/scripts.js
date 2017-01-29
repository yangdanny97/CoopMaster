
document.getElementById('project-btn').addEventListener('click',function() {
        $('html, body').animate({
            scrollTop: $("#project-marker").offset().top
        }, 600)
    });

document.getElementById('team-btn').addEventListener('click',function() {
        $('html, body').animate({
            scrollTop: $("#team-marker").offset().top
        }, 600)
    });
