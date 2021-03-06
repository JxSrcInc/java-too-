package jxsource.playground.mockito;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class WorkerTest {
	@Test
	public void testNull() {
		FilterChain chain = mock(FilterChain.class);
		Response response = new ResponseImpl();
		Request request = null;
		new Worker().doFilter(chain, request, response);
		verify(chain).doFilter(argThat(new RequestMatcher()), argThat(new ResponseMatcher(response)));
	}
	@Test
	public void test() {
		FilterChain chain = mock(FilterChain.class);
		Response response = new ResponseImpl();
		Request request = new Request() {};
		new Worker().doFilter(chain, request, response);
		verify(chain).doFilter(argThat(new RequestMatcher()), argThat(new ResponseMatcher(response)));
	}
}
