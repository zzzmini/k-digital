import { productFeatures } from "../../data/productFeatures";

export default function DetailInfo({ product }) {
  const features = productFeatures[product?.id] ?? productFeatures.default;

  return (
    <div className="section-card mt-3">
      <h5>이 제품이 좋은 이유</h5>
      <ul>
        {features.map((f, i) => <li key={i}>{f}</li>)}
      </ul>

      <p className="muted small mb-0">* 사용자 모니터/발형에 따라 체감이 다를 수 있어요.</p>
    </div>
  );
}