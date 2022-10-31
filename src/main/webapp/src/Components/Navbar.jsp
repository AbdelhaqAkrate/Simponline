<div class="absolute top-0 left-0 right-0 flex justify-between items-center text-white p-2 border-b-4 border-black-600">
    <div class="ml-20">
        <div class="flex flex-col justify-center">
            <img src="http://localhost/pictures/logo.png" class="self-center" width="50" height="50">
        </div>
    </div>
    <nav class="">

        <ul class="flex gap-20 text-sm font-medium text-green-900">
            <li><a href="${pageContext.request.contextPath}/brief" class="mb-2 border-b-2">Brief</a></li>
            <li><a href="${pageContext.request.contextPath}/assignment">Assignment</a></li>
        </ul>
    </nav>
    <div class="mr-20">
        <button type="submit" class="bg-green-300 text-[#4B476A] text-sm font-bold px-4 py-2 rounded-full"><a href="${pageContext.request.contextPath}/room">Reserve Now</a></button>
    </div>
</div>