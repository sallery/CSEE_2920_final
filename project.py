import time
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

TRIG = 23
ECHO = 24
count = 0

GPIO.setup(TRIG, GPIO.OUT)
GPIO.setup(ECHO, GPIO.IN)
GPIO.output(TRIG, 0)

try:

	GPIO.output(TRIG,0)
	time.sleep(0.1)

	print "Starting measurement..."

	GPIO.output(TRIG, 1)
	time.sleep(0.00001)
	GPIO.output(TRIG, 0)

	while GPIO.input(ECHO) == 0:
       		pass
	start = time.time()

	while GPIO.input(ECHO) == 1:
       		pass
	stop = time.time()
	distance = (stop-start) * 17000
	if distance < 10000:
		print "Phone detected."
		while True:
			time.sleep(60)
			count = count+1
	else:
		print "No phone detected."

except KeyboardInterrupt:
	f= open("info.txt","w+")
	points = count/2
	f.write("Points earned:%d\r\n"%points)
	print "Minutes used: ", count
	print "Points earned: ", points
	f.close()
except:
	print "Error"

finally:
	GPIO.cleanup()
