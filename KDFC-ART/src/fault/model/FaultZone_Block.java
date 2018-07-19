package fault.model;

import auxiliary.model.Point;

public class FaultZone_Block extends FaultZone {   //��״ʧЧģʽ

	public int[][] inputDomain; // ������Χ
	public Point faultPoint; // ���϶���
	public float delta; // ʧЧ����ı߳�

	public FaultZone_Block() {

	}
 
	public FaultZone_Block(int[][] boundary, double area) {
		inputDomain = boundary;
		int n = boundary.length;
		theta = area;
		double sum = 1.0;
		
		for (int i = 0; i < n; i++) {
			sum = sum * (inputDomain[i][1] - inputDomain[i][0]); // �������ռ��С
		}
		
		delta = (float) Math.pow(sum * theta, 1.0 / n);
		faultPoint = new Point(n);

		for (int i = 0; i < n; i++) {
			faultPoint.coordPoint[i] = inputDomain[i][0]+ (float) ((inputDomain[i][1] - inputDomain[i][0] - delta) * Math.random());
		} 
		
	}

	@Override
	public Boolean findTarget(Point p) {   //�ж��Ƿ���ʧЧ
		// TODO Auto-generated method stub
		for (int i = 0; i < p.n; i++) {
			if (!((p.coordPoint[i] >= this.faultPoint.coordPoint[i]) && (p.coordPoint[i] <= this.faultPoint.coordPoint[i] + this.delta))) {
				return false;
			}
		}
		return true;
	}

}
