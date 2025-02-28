document.addEventListener("DOMContentLoaded", function () {
    let sidebar = document.querySelector(".sidebar");
    let closeBtn = document.querySelector("#btn");
    let navList = document.querySelector(".nav-list");
    let submenuToggles = document.querySelectorAll(".submenu-toggle");

    if (!sidebar || !closeBtn || !navList) return;

    sidebar.classList.remove("open");

    closeBtn.addEventListener("click", () => {
        sidebar.classList.toggle("open");
        navList.classList.toggle("scroll");
        menuBtnChange();
    });

    submenuToggles.forEach(toggle => {
        toggle.addEventListener("click", () => {
            let submenu = toggle.nextElementSibling;
            if (submenu) {
                submenu.classList.toggle("show");
            }
            let arrow = toggle.querySelector(".submenu-arrow");
            if (arrow) {
                arrow.classList.toggle("rotate");
            }
        });
    });

    function menuBtnChange() {
        if (sidebar.classList.contains("open")) {
            closeBtn.classList.replace("bi-list", "bi-x");
        } else {
            closeBtn.classList.replace("bi-x", "bi-list");
        }
    }
});