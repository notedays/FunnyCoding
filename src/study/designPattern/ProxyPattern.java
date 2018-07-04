package study.designPattern;

/*
 * # [ 프록시 패턴 정의 ] ============================================================
 * 
 * - 실체 오브젝트의 행위를 대신 수행하는 대리오브젝트 
 * - 실체 오브젝트 행위의 일부분을 도맡아서 하거나 실행 전후에 다른 동작을 덧붙여서 동작할 수 있다.
 * 
 * - 마치 비서 같은 존재 - 실행 요청자의 경우, 실체 (사장)가 처리하는지 프록시(비서)가 처리하는지 알 수 없음 
 * - but, 결과가 변하지 않도록 실체의 동작 로직에 변화를 주면 X 
 * - 실체 동작(사장의 명령)은 그대로 유지하면서 프록시(비서)의 추가적인 동작등 추가 가능
 * 
 * - 실체의 동작이 오래 걸리는 작업인 경우 프록시가 그 실체 작업의 부분 부분만 대신 작동이 가능
 * 
 * 
 * # [ 사용 예제 ] =================================================================
 * 
 * @ 가상 프록시 
 * 	높은 cost 객체 대신 스켈레톤 객체(인터페이스만 존재하고 실제로 인스턴스를 생성하지 않는 객체)를 사용하여 실질적으로
 * 	객체가 필요할때까지 높은 cost의 객체 생성을 지연시켜 메모리를 절약할 수 있다.
 * 
 * @ 원격 프록시 
 * 	서로 다른 머신에 있는 객체에 대해 제공할 수 있다(또는 객체를 사용할 수 있다). 
 * 	일반적인 예는 JAVA의 RMI이다.
 * 	http://www.informit.com/articles/article.aspx?p=1398608&seqNum=3
 * 
 * @ 보호 프록시 
 * 	객체에 대해 액세스 할 수있는 권한을 부여할 수 있다.
 * 
 * @ 정교한 참조 프록시 
 * 	객체에 정교한 작업을 부여할 수 있다. 
 * 	예를들어 객체를 생성할 때 카운팅 기능을 추가적으로 작업할 수 있다.
 * 
 * 
 * # [ 패턴 비교 ] ==================================================================
 * 
 * - 어뎁터 패턴 어뎁터 패턴은 실제 오브젝트와 다른 인터페이스를 제공하여 실제 오브젝트를 사용할 수 있도록 도와준다. 
 * 	그러나 프록시 패턴은 실제 오브젝트와 동일한 인터페이스를 제공한다.
 * 
 * - 데코레이터 패턴 데코레이터 패턴은 런타임에 실제 객체에 동작을 추가한다. 그러나 프록시는 동작을 제어하지 않고 동작을 변경하지 않는다.
 * 
 */
public class ProxyPattern {

	// # interface 
	interface CommandExecutor {
		public void runCommand(String cmd) throws Exception;
	}

	// # impl 클래스
	class CommandExecutorImpl implements CommandExecutor {
		int count;

		@Override
		public void runCommand(String cmd) throws Exception {
			while (count++ < 10) {
				System.out.println(count + " 회 실행!");
				Thread.sleep(1000);
			}
		}
	}

	// # proxy 클래스
	class CommandExecutorProxy implements CommandExecutor {
		private boolean isAdmin;
		private CommandExecutor executor;

		public CommandExecutorProxy(String user, String password) {
			if ("tester".equals(user) && "test01".equals(password)) {
				isAdmin = true;
			}
			executor = new CommandExecutorImpl();
		}

		@Override
		public void runCommand(String cmd) throws Exception {
			if (isAdmin) {
				executor.runCommand(cmd);
			} else {
				if (cmd.startsWith("rm")) {
					throw new Exception("rm is only admin");
				} else {
					executor.runCommand(cmd);
				}
			}
		}

	}

	public ProxyPattern() {
		CommandExecutor executor = new CommandExecutorProxy("test", "wrong_pwd");
		try {
			executor.runCommand("rm -rf *");
			executor.runCommand("ls -al");
		} catch (Exception e) {
			System.out.println("Exception Message : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new ProxyPattern();
	}
}
