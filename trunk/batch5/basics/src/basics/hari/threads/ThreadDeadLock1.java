package basics.hari.threads;

public class ThreadDeadLock1 {

	class FirstThread extends Thread {

		SharedObject s1;
		SharedObject1 s2;

		public FirstThread(SharedObject s1, SharedObject1 s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public void run() {
			try {

				synchronized (s1) {
					// sleep(5000);
					synchronized (s2) {
						s1.displayNumbers();
						sleep(5000);

						s2.displayNumbers();

					}
				}
				return;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	class SecondThread extends Thread {
		SharedObject s1;
		SharedObject1 s2;

		public SecondThread(SharedObject s1, SharedObject1 s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public void run() {
			try {
				synchronized (s2) {
					// sleep(5000);
					s2.wait();

					synchronized (s1) {
						s2.displayNumbers();
						sleep(5000);

						s1.displayNumbers();

					}
				}
				return;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	class SharedObject {
		private int id;

		public SharedObject(int id) {
			System.out.println("new shared object with ID " + id);
			this.id = id;
		}

		public void displayNumbers() {
			for (int i = 0; i < 10; i++) {
				System.out.println("SharedObject with id " + id + "  -> " + i);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		private void sayHello() {
			System.out.println("Hello Friend");

		}

		public synchronized boolean checkLock() {
			System.out.println("yes I got lock");
			return true;

		}

	}

	class SharedObject1 {
		private int id;

		SharedObject1(int id) {
			System.out.println("new shared object 1 with ID " + id);
			this.id = id;
		}

		public void displayNumbers() {
			for (int i = 10; i < 20; i++) {
				System.out.println("SharedObject1 with id " + id + "  -> " + i);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		public synchronized boolean checkLock() {
			System.out.println("yes I got lock");
			return true;

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ThreadDeadLock1 m = new ThreadDeadLock1();

		SharedObject s1 = m.new SharedObject(1);

		SharedObject1 s2 = m.new SharedObject1(2);

		FirstThread t1 = m.new FirstThread(s1, s2);

		SecondThread t2 = m.new SecondThread(s1, s2);
		t1.start();
		t2.start();

	}

}
