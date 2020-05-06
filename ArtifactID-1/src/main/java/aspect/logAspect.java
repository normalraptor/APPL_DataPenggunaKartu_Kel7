package aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class logAspect {
	@Pointcut("execution(** query.IQuery.create(..))")
	public void creation() {}
	
	@Pointcut("execution(** query.IQuery.update(..))")
	public void makeUpdate() {}
	
	@Pointcut("execution(** query.IQuery.delete(..))")
	public void deletion() {}
	
	@Before("creation()")
	public void beforecreateexec(JoinPoint pnt) {
		System.out.println("currently creating new entry...." + pnt.getSignature().getName());
	}
	
	@After("creation()")
	public void aftercreateexec(JoinPoint pnt) {
		System.out.println("new entry added! " + pnt.getSignature().getName());
	}
	
	@AfterThrowing("creation()")
	public void aftercreatefailed(JoinPoint pnt) {
		System.out.println("some error occured, failed to add " + pnt.getSignature().getName());
	}
	
	@Before("makeUpdate()")
	public void beforeupdateexec(JoinPoint pnt) {
		System.out.println("currently updating the entry...." + pnt.getSignature().getName());
	}
	
	@After("makeUpdate()")
	public void afterupdateexec(JoinPoint pnt) {
		System.out.println("entry updated! " + pnt.getSignature().getName());
	}
	
	@AfterThrowing("creation()")
	public void afterupdatefailed(JoinPoint pnt) {
		System.out.println("some error occured, failed to update " + pnt.getSignature().getName());
	}
	
	@Before("deletion()")
	public void beforedeleteexec(JoinPoint pnt) {
		System.out.println("currently deleting the entry...." + pnt.getSignature().getName());
	}
	
	@After("creation()")
	public void afterdeleteexec(JoinPoint pnt) {
		System.out.println("entry deleted! " + pnt.getSignature().getName());
	}
	
	@AfterThrowing("creation()")
	public void afterdeletefailed(JoinPoint pnt) {
		System.out.println("some error occured, failed to delete " + pnt.getSignature().getName());
	}
}
