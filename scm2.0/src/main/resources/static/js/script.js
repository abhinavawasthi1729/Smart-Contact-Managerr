console.log("spript loaded")

let currentTheme=getTheme();

document.addEventListener("DOMContentLoaded", ()=>{
    changeTheme();
});



function changeTheme( ) {
    document.querySelector('html').classList.add(currentTheme);
}

    const themeChangeButton=document.querySelector("#theme_change_button");
    themeChangeButton.addEventListener("click", (event)=>{
        document.querySelector('html').classList.remove(currentTheme);

        if(currentTheme==="dark"){
            currentTheme="light"
            themeChangeButton.querySelector("span").textContent="Dark";
        }else{
            currentTheme="dark";
            themeChangeButton.querySelector("span").textContent="Light";
        }

        document.querySelector('html').classList.add(currentTheme);

    });




function setTheme(theme){
    localStorage.setItem("currentTheme", theme);
}

function getTheme(){
    const theme= localStorage.getItem("currentTheme");

    return theme?theme:"light";
}
