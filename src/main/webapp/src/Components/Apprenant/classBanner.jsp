<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <div class="absolute top-0 left-0 right-0 bottom-0 mt-28 text-white font-bold" style="text-align: center; font-size: 48px">
      <div class="container mx-auto p-4 border border-indigo-600 flex justify-start content-center items-center">
        <!-- ... -->
        
        <!-- create a circle div for avatar -->
        <div class="rounded-full h-24 w-24 bg-gray-200" style="display: flex; justify-content: center; align-content: center;">
          <!-- ... -->
            <div class="text-4xl font-bold text-center" style="display: flex; justify-content: center; align-items: center;">
               <div> ${apprenant.getNom().substring(0,1)} app </div>
            </div>
            
        </div>
        <!-- center name beside the rounded circle -->
        <div class="text-center mt-4 text-black">
          <div class="text-2xl font-bold">${apprenant.getNom()} ${apprenant.getPrenom()} Abdelhaq Akrate</div>
        </div>
       
      </div>
    </div>
</div>