<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/getStudentTrainingStatus"/>
<!DOCTYPE html>
<html>
    <body>
        
            <p>My salary is: <c:out value="${messages.status}"/><p>
        
    </body>
</html>