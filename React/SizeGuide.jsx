export default function SizeGuide() {
  return (
    <div className="section-card mt-3">
      <p className="muted">대부분 <strong>정사이즈</strong>를 권장합니다.</p>
      <ul>
        <li>발볼이 넓으면 <strong>+5~10mm</strong> 여유 있게 선택</li>
        <li>레이싱/타이트 핏을 원하면 <strong>-5mm</strong> 고려</li>
        <li>스포츠 양말 기준, 두꺼운 양말은 반 치수 업</li>
      </ul>

      <h6 className="mt-3">치수 변환 (퀵 레퍼런스)</h6>
      <p className="mb-1"><strong>KR 240</strong> ≈ US 6 ≈ EU 38</p>
      <p className="mb-1"><strong>KR 250</strong> ≈ US 7 ≈ EU 39.5</p>
      <p className="mb-1"><strong>KR 260</strong> ≈ US 8 ≈ EU 41</p>
      <p className="mb-1"><strong>KR 270</strong> ≈ US 9 ≈ EU 42.5</p>
      <p className="mb-0"><strong>KR 280</strong> ≈ US 10 ≈ EU 44</p>
    </div>
  );
}