console.log("script loaded");


 let  currentTheme = getTheme();
 //initially-->
 changeTheme();

 //todo:
function changeTheme(){
//set to web page
 document.querySelector("html").classList.add(currentTheme);

// set the listener to change theme button
   changeThemeButton=document.querySelector('#theme_change_btn')
   changeThemeButton.addEventListener('click',(event)=>{
       console.log("Change theme button clicked");
       const oldTheme = currentTheme;
           if(currentTheme == "dark"){
               currentTheme="light";
           }
           else {
               currentTheme = "dark";
           }
    //Local storage me bhi save karenge
    setTheme(currentTheme);
       document.querySelector('html').classList.remove(oldTheme);
           document.querySelector('html').classList.add(currentTheme);

           //change the text on change mode of light
          changeThemeButton.querySelector('span').textContent=currentTheme;
   });
}



//set theme to local storage
   function setTheme(theme){
    localStorage.setItem("theme",theme);
   }

//get theme from local storage
 function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme) return theme;
    else return "light";
 }