// Generated from app/modules/antlr4/SqlBase.g4 by ANTLR 4.9.0-SNAPSHOT


import { ParseTreeListener } from "antlr4ts/tree/ParseTreeListener";

import { TableNameContext } from "./SqlBaseParser";
import { SubqueryRelationContext } from "./SqlBaseParser";
import { UnnestContext } from "./SqlBaseParser";
import { LateralContext } from "./SqlBaseParser";
import { ParenthesizedRelationContext } from "./SqlBaseParser";
import { JoinRelationContext } from "./SqlBaseParser";
import { RelationDefaultContext } from "./SqlBaseParser";
import { ComparisonContext } from "./SqlBaseParser";
import { QuantifiedComparisonContext } from "./SqlBaseParser";
import { BetweenContext } from "./SqlBaseParser";
import { InListContext } from "./SqlBaseParser";
import { InSubqueryContext } from "./SqlBaseParser";
import { LikeContext } from "./SqlBaseParser";
import { NullPredicateContext } from "./SqlBaseParser";
import { DistinctFromContext } from "./SqlBaseParser";
import { DecimalLiteralContext } from "./SqlBaseParser";
import { DoubleLiteralContext } from "./SqlBaseParser";
import { IntegerLiteralContext } from "./SqlBaseParser";
import { QueryTermDefaultContext } from "./SqlBaseParser";
import { SetOperationContext } from "./SqlBaseParser";
import { UnquotedIdentifierContext } from "./SqlBaseParser";
import { QuotedIdentifierContext } from "./SqlBaseParser";
import { BackQuotedIdentifierContext } from "./SqlBaseParser";
import { DigitIdentifierContext } from "./SqlBaseParser";
import { ExplainFormatContext } from "./SqlBaseParser";
import { ExplainTypeContext } from "./SqlBaseParser";
import { SingleGroupingSetContext } from "./SqlBaseParser";
import { RollupContext } from "./SqlBaseParser";
import { CubeContext } from "./SqlBaseParser";
import { MultipleGroupingSetsContext } from "./SqlBaseParser";
import { ReadUncommittedContext } from "./SqlBaseParser";
import { ReadCommittedContext } from "./SqlBaseParser";
import { RepeatableReadContext } from "./SqlBaseParser";
import { SerializableContext } from "./SqlBaseParser";
import { ValueExpressionDefaultContext } from "./SqlBaseParser";
import { AtTimeZoneContext } from "./SqlBaseParser";
import { ArithmeticUnaryContext } from "./SqlBaseParser";
import { ArithmeticBinaryContext } from "./SqlBaseParser";
import { ConcatenationContext } from "./SqlBaseParser";
import { BasicStringLiteralContext } from "./SqlBaseParser";
import { UnicodeStringLiteralContext } from "./SqlBaseParser";
import { CurrentUserGrantorContext } from "./SqlBaseParser";
import { CurrentRoleGrantorContext } from "./SqlBaseParser";
import { SpecifiedPrincipalContext } from "./SqlBaseParser";
import { UserPrincipalContext } from "./SqlBaseParser";
import { RolePrincipalContext } from "./SqlBaseParser";
import { UnspecifiedPrincipalContext } from "./SqlBaseParser";
import { UnboundedFrameContext } from "./SqlBaseParser";
import { CurrentRowBoundContext } from "./SqlBaseParser";
import { BoundedFrameContext } from "./SqlBaseParser";
import { StatementDefaultContext } from "./SqlBaseParser";
import { UseContext } from "./SqlBaseParser";
import { CreateSchemaContext } from "./SqlBaseParser";
import { DropSchemaContext } from "./SqlBaseParser";
import { RenameSchemaContext } from "./SqlBaseParser";
import { CreateTableAsSelectContext } from "./SqlBaseParser";
import { CreateTableContext } from "./SqlBaseParser";
import { DropTableContext } from "./SqlBaseParser";
import { InsertIntoContext } from "./SqlBaseParser";
import { UpdateContext } from "./SqlBaseParser";
import { DeleteContext } from "./SqlBaseParser";
import { RenameTableContext } from "./SqlBaseParser";
import { RenameColumnContext } from "./SqlBaseParser";
import { DropColumnContext } from "./SqlBaseParser";
import { AddColumnContext } from "./SqlBaseParser";
import { AnalyzeContext } from "./SqlBaseParser";
import { CreateTypeContext } from "./SqlBaseParser";
import { CreateViewContext } from "./SqlBaseParser";
import { DropViewContext } from "./SqlBaseParser";
import { CreateMaterializedViewContext } from "./SqlBaseParser";
import { DropMaterializedViewContext } from "./SqlBaseParser";
import { RefreshMaterializedViewContext } from "./SqlBaseParser";
import { CreateFunctionContext } from "./SqlBaseParser";
import { AlterFunctionContext } from "./SqlBaseParser";
import { DropFunctionContext } from "./SqlBaseParser";
import { CallContext } from "./SqlBaseParser";
import { CreateRoleContext } from "./SqlBaseParser";
import { DropRoleContext } from "./SqlBaseParser";
import { GrantRolesContext } from "./SqlBaseParser";
import { RevokeRolesContext } from "./SqlBaseParser";
import { SetRoleContext } from "./SqlBaseParser";
import { GrantContext } from "./SqlBaseParser";
import { RevokeContext } from "./SqlBaseParser";
import { ShowGrantsContext } from "./SqlBaseParser";
import { ExplainContext } from "./SqlBaseParser";
import { ShowCreateTableContext } from "./SqlBaseParser";
import { ShowCreateViewContext } from "./SqlBaseParser";
import { ShowCreateMaterializedViewContext } from "./SqlBaseParser";
import { ShowCreateFunctionContext } from "./SqlBaseParser";
import { ShowTablesContext } from "./SqlBaseParser";
import { ShowSchemasContext } from "./SqlBaseParser";
import { ShowCatalogsContext } from "./SqlBaseParser";
import { ShowColumnsContext } from "./SqlBaseParser";
import { ShowStatsContext } from "./SqlBaseParser";
import { ShowStatsForQueryContext } from "./SqlBaseParser";
import { ShowRolesContext } from "./SqlBaseParser";
import { ShowRoleGrantsContext } from "./SqlBaseParser";
import { ShowFunctionsContext } from "./SqlBaseParser";
import { ShowSessionContext } from "./SqlBaseParser";
import { SetSessionContext } from "./SqlBaseParser";
import { ResetSessionContext } from "./SqlBaseParser";
import { StartTransactionContext } from "./SqlBaseParser";
import { CommitContext } from "./SqlBaseParser";
import { RollbackContext } from "./SqlBaseParser";
import { PrepareContext } from "./SqlBaseParser";
import { DeallocateContext } from "./SqlBaseParser";
import { ExecuteContext } from "./SqlBaseParser";
import { DescribeInputContext } from "./SqlBaseParser";
import { DescribeOutputContext } from "./SqlBaseParser";
import { TimeZoneIntervalContext } from "./SqlBaseParser";
import { TimeZoneStringContext } from "./SqlBaseParser";
import { QueryPrimaryDefaultContext } from "./SqlBaseParser";
import { TableContext } from "./SqlBaseParser";
import { InlineTableContext } from "./SqlBaseParser";
import { SubqueryContext } from "./SqlBaseParser";
import { NullLiteralContext } from "./SqlBaseParser";
import { IntervalLiteralContext } from "./SqlBaseParser";
import { TypeConstructorContext } from "./SqlBaseParser";
import { NumericLiteralContext } from "./SqlBaseParser";
import { BooleanLiteralContext } from "./SqlBaseParser";
import { StringLiteralContext } from "./SqlBaseParser";
import { BinaryLiteralContext } from "./SqlBaseParser";
import { ParameterContext } from "./SqlBaseParser";
import { PositionContext } from "./SqlBaseParser";
import { RowConstructorContext } from "./SqlBaseParser";
import { FunctionCallContext } from "./SqlBaseParser";
import { LambdaContext } from "./SqlBaseParser";
import { SubqueryExpressionContext } from "./SqlBaseParser";
import { ExistsContext } from "./SqlBaseParser";
import { SimpleCaseContext } from "./SqlBaseParser";
import { SearchedCaseContext } from "./SqlBaseParser";
import { CastContext } from "./SqlBaseParser";
import { ArrayConstructorContext } from "./SqlBaseParser";
import { SubscriptContext } from "./SqlBaseParser";
import { ColumnReferenceContext } from "./SqlBaseParser";
import { DereferenceContext } from "./SqlBaseParser";
import { SpecialDateTimeFunctionContext } from "./SqlBaseParser";
import { CurrentUserContext } from "./SqlBaseParser";
import { SubstringContext } from "./SqlBaseParser";
import { NormalizeContext } from "./SqlBaseParser";
import { ExtractContext } from "./SqlBaseParser";
import { ParenthesizedExpressionContext } from "./SqlBaseParser";
import { GroupingOperationContext } from "./SqlBaseParser";
import { IsolationLevelContext } from "./SqlBaseParser";
import { TransactionAccessModeContext } from "./SqlBaseParser";
import { SelectContext } from "./SqlBaseParser";
import { SelectAllContext } from "./SqlBaseParser";
import { PredicatedContext } from "./SqlBaseParser";
import { LogicalNotContext } from "./SqlBaseParser";
import { LogicalBinaryContext } from "./SqlBaseParser";
import { PositionalArgumentContext } from "./SqlBaseParser";
import { NamedArgumentContext } from "./SqlBaseParser";
import { SingleStatementContext } from "./SqlBaseParser";
import { StandaloneExpressionContext } from "./SqlBaseParser";
import { StandaloneRoutineBodyContext } from "./SqlBaseParser";
import { StatementContext } from "./SqlBaseParser";
import { QueryContext } from "./SqlBaseParser";
import { QueryWithContext } from "./SqlBaseParser";
import { TableElementContext } from "./SqlBaseParser";
import { ColumnDefinitionContext } from "./SqlBaseParser";
import { LikeClauseContext } from "./SqlBaseParser";
import { PropertiesContext } from "./SqlBaseParser";
import { PropertyContext } from "./SqlBaseParser";
import { SqlParameterDeclarationContext } from "./SqlBaseParser";
import { RoutineCharacteristicsContext } from "./SqlBaseParser";
import { RoutineCharacteristicContext } from "./SqlBaseParser";
import { AlterRoutineCharacteristicsContext } from "./SqlBaseParser";
import { AlterRoutineCharacteristicContext } from "./SqlBaseParser";
import { RoutineBodyContext } from "./SqlBaseParser";
import { ReturnStatementContext } from "./SqlBaseParser";
import { ExternalBodyReferenceContext } from "./SqlBaseParser";
import { LanguageContext } from "./SqlBaseParser";
import { DeterminismContext } from "./SqlBaseParser";
import { NullCallClauseContext } from "./SqlBaseParser";
import { ExternalRoutineNameContext } from "./SqlBaseParser";
import { QueryNoWithContext } from "./SqlBaseParser";
import { QueryTermContext } from "./SqlBaseParser";
import { QueryPrimaryContext } from "./SqlBaseParser";
import { SortItemContext } from "./SqlBaseParser";
import { QuerySpecificationContext } from "./SqlBaseParser";
import { GroupByContext } from "./SqlBaseParser";
import { GroupingElementContext } from "./SqlBaseParser";
import { GroupingSetContext } from "./SqlBaseParser";
import { NamedQueryContext } from "./SqlBaseParser";
import { SetQuantifierContext } from "./SqlBaseParser";
import { SelectItemContext } from "./SqlBaseParser";
import { RelationContext } from "./SqlBaseParser";
import { JoinTypeContext } from "./SqlBaseParser";
import { JoinCriteriaContext } from "./SqlBaseParser";
import { SampledRelationContext } from "./SqlBaseParser";
import { SampleTypeContext } from "./SqlBaseParser";
import { AliasedRelationContext } from "./SqlBaseParser";
import { ColumnAliasesContext } from "./SqlBaseParser";
import { RelationPrimaryContext } from "./SqlBaseParser";
import { ExpressionContext } from "./SqlBaseParser";
import { WhereExpressionContext } from "./SqlBaseParser";
import { UpdateExpressionContext } from "./SqlBaseParser";
import { HavingExpressionContext } from "./SqlBaseParser";
import { BooleanExpressionContext } from "./SqlBaseParser";
import { PredicateContext } from "./SqlBaseParser";
import { ValueExpressionContext } from "./SqlBaseParser";
import { PrimaryExpressionContext } from "./SqlBaseParser";
import { StringContext } from "./SqlBaseParser";
import { NullTreatmentContext } from "./SqlBaseParser";
import { TimeZoneSpecifierContext } from "./SqlBaseParser";
import { ComparisonOperatorContext } from "./SqlBaseParser";
import { ComparisonQuantifierContext } from "./SqlBaseParser";
import { BooleanValueContext } from "./SqlBaseParser";
import { IntervalContext } from "./SqlBaseParser";
import { IntervalFieldContext } from "./SqlBaseParser";
import { NormalFormContext } from "./SqlBaseParser";
import { TypesContext } from "./SqlBaseParser";
import { TypeContext } from "./SqlBaseParser";
import { TypeParameterContext } from "./SqlBaseParser";
import { BaseTypeContext } from "./SqlBaseParser";
import { WhenClauseContext } from "./SqlBaseParser";
import { FilterContext } from "./SqlBaseParser";
import { OverContext } from "./SqlBaseParser";
import { WindowFrameContext } from "./SqlBaseParser";
import { FrameBoundContext } from "./SqlBaseParser";
import { ExplainOptionContext } from "./SqlBaseParser";
import { TransactionModeContext } from "./SqlBaseParser";
import { LevelOfIsolationContext } from "./SqlBaseParser";
import { CallArgumentContext } from "./SqlBaseParser";
import { PrivilegeContext } from "./SqlBaseParser";
import { QualifiedNameContext } from "./SqlBaseParser";
import { TableNameWithAliasesContext } from "./SqlBaseParser";
import { GrantorContext } from "./SqlBaseParser";
import { PrincipalContext } from "./SqlBaseParser";
import { RolesContext } from "./SqlBaseParser";
import { IdentifierContext } from "./SqlBaseParser";
import { NumberContext } from "./SqlBaseParser";
import { NonReservedContext } from "./SqlBaseParser";


/**
 * This interface defines a complete listener for a parse tree produced by
 * `SqlBaseParser`.
 */
export interface SqlBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the `tableName`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterTableName?: (ctx: TableNameContext) => void;
	/**
	 * Exit a parse tree produced by the `tableName`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitTableName?: (ctx: TableNameContext) => void;

	/**
	 * Enter a parse tree produced by the `subqueryRelation`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterSubqueryRelation?: (ctx: SubqueryRelationContext) => void;
	/**
	 * Exit a parse tree produced by the `subqueryRelation`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitSubqueryRelation?: (ctx: SubqueryRelationContext) => void;

	/**
	 * Enter a parse tree produced by the `unnest`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterUnnest?: (ctx: UnnestContext) => void;
	/**
	 * Exit a parse tree produced by the `unnest`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitUnnest?: (ctx: UnnestContext) => void;

	/**
	 * Enter a parse tree produced by the `lateral`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterLateral?: (ctx: LateralContext) => void;
	/**
	 * Exit a parse tree produced by the `lateral`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitLateral?: (ctx: LateralContext) => void;

	/**
	 * Enter a parse tree produced by the `parenthesizedRelation`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterParenthesizedRelation?: (ctx: ParenthesizedRelationContext) => void;
	/**
	 * Exit a parse tree produced by the `parenthesizedRelation`
	 * labeled alternative in `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitParenthesizedRelation?: (ctx: ParenthesizedRelationContext) => void;

	/**
	 * Enter a parse tree produced by the `joinRelation`
	 * labeled alternative in `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	enterJoinRelation?: (ctx: JoinRelationContext) => void;
	/**
	 * Exit a parse tree produced by the `joinRelation`
	 * labeled alternative in `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	exitJoinRelation?: (ctx: JoinRelationContext) => void;

	/**
	 * Enter a parse tree produced by the `relationDefault`
	 * labeled alternative in `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	enterRelationDefault?: (ctx: RelationDefaultContext) => void;
	/**
	 * Exit a parse tree produced by the `relationDefault`
	 * labeled alternative in `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	exitRelationDefault?: (ctx: RelationDefaultContext) => void;

	/**
	 * Enter a parse tree produced by the `comparison`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterComparison?: (ctx: ComparisonContext) => void;
	/**
	 * Exit a parse tree produced by the `comparison`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitComparison?: (ctx: ComparisonContext) => void;

	/**
	 * Enter a parse tree produced by the `quantifiedComparison`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterQuantifiedComparison?: (ctx: QuantifiedComparisonContext) => void;
	/**
	 * Exit a parse tree produced by the `quantifiedComparison`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitQuantifiedComparison?: (ctx: QuantifiedComparisonContext) => void;

	/**
	 * Enter a parse tree produced by the `between`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterBetween?: (ctx: BetweenContext) => void;
	/**
	 * Exit a parse tree produced by the `between`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitBetween?: (ctx: BetweenContext) => void;

	/**
	 * Enter a parse tree produced by the `inList`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterInList?: (ctx: InListContext) => void;
	/**
	 * Exit a parse tree produced by the `inList`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitInList?: (ctx: InListContext) => void;

	/**
	 * Enter a parse tree produced by the `inSubquery`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterInSubquery?: (ctx: InSubqueryContext) => void;
	/**
	 * Exit a parse tree produced by the `inSubquery`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitInSubquery?: (ctx: InSubqueryContext) => void;

	/**
	 * Enter a parse tree produced by the `like`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterLike?: (ctx: LikeContext) => void;
	/**
	 * Exit a parse tree produced by the `like`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitLike?: (ctx: LikeContext) => void;

	/**
	 * Enter a parse tree produced by the `nullPredicate`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterNullPredicate?: (ctx: NullPredicateContext) => void;
	/**
	 * Exit a parse tree produced by the `nullPredicate`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitNullPredicate?: (ctx: NullPredicateContext) => void;

	/**
	 * Enter a parse tree produced by the `distinctFrom`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterDistinctFrom?: (ctx: DistinctFromContext) => void;
	/**
	 * Exit a parse tree produced by the `distinctFrom`
	 * labeled alternative in `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitDistinctFrom?: (ctx: DistinctFromContext) => void;

	/**
	 * Enter a parse tree produced by the `decimalLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	enterDecimalLiteral?: (ctx: DecimalLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `decimalLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	exitDecimalLiteral?: (ctx: DecimalLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `doubleLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	enterDoubleLiteral?: (ctx: DoubleLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `doubleLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	exitDoubleLiteral?: (ctx: DoubleLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `integerLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	enterIntegerLiteral?: (ctx: IntegerLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `integerLiteral`
	 * labeled alternative in `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	exitIntegerLiteral?: (ctx: IntegerLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `queryTermDefault`
	 * labeled alternative in `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	enterQueryTermDefault?: (ctx: QueryTermDefaultContext) => void;
	/**
	 * Exit a parse tree produced by the `queryTermDefault`
	 * labeled alternative in `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	exitQueryTermDefault?: (ctx: QueryTermDefaultContext) => void;

	/**
	 * Enter a parse tree produced by the `setOperation`
	 * labeled alternative in `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	enterSetOperation?: (ctx: SetOperationContext) => void;
	/**
	 * Exit a parse tree produced by the `setOperation`
	 * labeled alternative in `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	exitSetOperation?: (ctx: SetOperationContext) => void;

	/**
	 * Enter a parse tree produced by the `unquotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	enterUnquotedIdentifier?: (ctx: UnquotedIdentifierContext) => void;
	/**
	 * Exit a parse tree produced by the `unquotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	exitUnquotedIdentifier?: (ctx: UnquotedIdentifierContext) => void;

	/**
	 * Enter a parse tree produced by the `quotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	enterQuotedIdentifier?: (ctx: QuotedIdentifierContext) => void;
	/**
	 * Exit a parse tree produced by the `quotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	exitQuotedIdentifier?: (ctx: QuotedIdentifierContext) => void;

	/**
	 * Enter a parse tree produced by the `backQuotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	enterBackQuotedIdentifier?: (ctx: BackQuotedIdentifierContext) => void;
	/**
	 * Exit a parse tree produced by the `backQuotedIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	exitBackQuotedIdentifier?: (ctx: BackQuotedIdentifierContext) => void;

	/**
	 * Enter a parse tree produced by the `digitIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	enterDigitIdentifier?: (ctx: DigitIdentifierContext) => void;
	/**
	 * Exit a parse tree produced by the `digitIdentifier`
	 * labeled alternative in `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	exitDigitIdentifier?: (ctx: DigitIdentifierContext) => void;

	/**
	 * Enter a parse tree produced by the `explainFormat`
	 * labeled alternative in `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	enterExplainFormat?: (ctx: ExplainFormatContext) => void;
	/**
	 * Exit a parse tree produced by the `explainFormat`
	 * labeled alternative in `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	exitExplainFormat?: (ctx: ExplainFormatContext) => void;

	/**
	 * Enter a parse tree produced by the `explainType`
	 * labeled alternative in `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	enterExplainType?: (ctx: ExplainTypeContext) => void;
	/**
	 * Exit a parse tree produced by the `explainType`
	 * labeled alternative in `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	exitExplainType?: (ctx: ExplainTypeContext) => void;

	/**
	 * Enter a parse tree produced by the `singleGroupingSet`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	enterSingleGroupingSet?: (ctx: SingleGroupingSetContext) => void;
	/**
	 * Exit a parse tree produced by the `singleGroupingSet`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	exitSingleGroupingSet?: (ctx: SingleGroupingSetContext) => void;

	/**
	 * Enter a parse tree produced by the `rollup`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	enterRollup?: (ctx: RollupContext) => void;
	/**
	 * Exit a parse tree produced by the `rollup`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	exitRollup?: (ctx: RollupContext) => void;

	/**
	 * Enter a parse tree produced by the `cube`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	enterCube?: (ctx: CubeContext) => void;
	/**
	 * Exit a parse tree produced by the `cube`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	exitCube?: (ctx: CubeContext) => void;

	/**
	 * Enter a parse tree produced by the `multipleGroupingSets`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	enterMultipleGroupingSets?: (ctx: MultipleGroupingSetsContext) => void;
	/**
	 * Exit a parse tree produced by the `multipleGroupingSets`
	 * labeled alternative in `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	exitMultipleGroupingSets?: (ctx: MultipleGroupingSetsContext) => void;

	/**
	 * Enter a parse tree produced by the `readUncommitted`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	enterReadUncommitted?: (ctx: ReadUncommittedContext) => void;
	/**
	 * Exit a parse tree produced by the `readUncommitted`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	exitReadUncommitted?: (ctx: ReadUncommittedContext) => void;

	/**
	 * Enter a parse tree produced by the `readCommitted`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	enterReadCommitted?: (ctx: ReadCommittedContext) => void;
	/**
	 * Exit a parse tree produced by the `readCommitted`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	exitReadCommitted?: (ctx: ReadCommittedContext) => void;

	/**
	 * Enter a parse tree produced by the `repeatableRead`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	enterRepeatableRead?: (ctx: RepeatableReadContext) => void;
	/**
	 * Exit a parse tree produced by the `repeatableRead`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	exitRepeatableRead?: (ctx: RepeatableReadContext) => void;

	/**
	 * Enter a parse tree produced by the `serializable`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	enterSerializable?: (ctx: SerializableContext) => void;
	/**
	 * Exit a parse tree produced by the `serializable`
	 * labeled alternative in `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	exitSerializable?: (ctx: SerializableContext) => void;

	/**
	 * Enter a parse tree produced by the `valueExpressionDefault`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterValueExpressionDefault?: (ctx: ValueExpressionDefaultContext) => void;
	/**
	 * Exit a parse tree produced by the `valueExpressionDefault`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitValueExpressionDefault?: (ctx: ValueExpressionDefaultContext) => void;

	/**
	 * Enter a parse tree produced by the `atTimeZone`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterAtTimeZone?: (ctx: AtTimeZoneContext) => void;
	/**
	 * Exit a parse tree produced by the `atTimeZone`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitAtTimeZone?: (ctx: AtTimeZoneContext) => void;

	/**
	 * Enter a parse tree produced by the `arithmeticUnary`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterArithmeticUnary?: (ctx: ArithmeticUnaryContext) => void;
	/**
	 * Exit a parse tree produced by the `arithmeticUnary`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitArithmeticUnary?: (ctx: ArithmeticUnaryContext) => void;

	/**
	 * Enter a parse tree produced by the `arithmeticBinary`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterArithmeticBinary?: (ctx: ArithmeticBinaryContext) => void;
	/**
	 * Exit a parse tree produced by the `arithmeticBinary`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitArithmeticBinary?: (ctx: ArithmeticBinaryContext) => void;

	/**
	 * Enter a parse tree produced by the `concatenation`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterConcatenation?: (ctx: ConcatenationContext) => void;
	/**
	 * Exit a parse tree produced by the `concatenation`
	 * labeled alternative in `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitConcatenation?: (ctx: ConcatenationContext) => void;

	/**
	 * Enter a parse tree produced by the `basicStringLiteral`
	 * labeled alternative in `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	enterBasicStringLiteral?: (ctx: BasicStringLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `basicStringLiteral`
	 * labeled alternative in `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	exitBasicStringLiteral?: (ctx: BasicStringLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `unicodeStringLiteral`
	 * labeled alternative in `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	enterUnicodeStringLiteral?: (ctx: UnicodeStringLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `unicodeStringLiteral`
	 * labeled alternative in `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	exitUnicodeStringLiteral?: (ctx: UnicodeStringLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `currentUserGrantor`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	enterCurrentUserGrantor?: (ctx: CurrentUserGrantorContext) => void;
	/**
	 * Exit a parse tree produced by the `currentUserGrantor`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	exitCurrentUserGrantor?: (ctx: CurrentUserGrantorContext) => void;

	/**
	 * Enter a parse tree produced by the `currentRoleGrantor`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	enterCurrentRoleGrantor?: (ctx: CurrentRoleGrantorContext) => void;
	/**
	 * Exit a parse tree produced by the `currentRoleGrantor`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	exitCurrentRoleGrantor?: (ctx: CurrentRoleGrantorContext) => void;

	/**
	 * Enter a parse tree produced by the `specifiedPrincipal`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	enterSpecifiedPrincipal?: (ctx: SpecifiedPrincipalContext) => void;
	/**
	 * Exit a parse tree produced by the `specifiedPrincipal`
	 * labeled alternative in `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	exitSpecifiedPrincipal?: (ctx: SpecifiedPrincipalContext) => void;

	/**
	 * Enter a parse tree produced by the `userPrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	enterUserPrincipal?: (ctx: UserPrincipalContext) => void;
	/**
	 * Exit a parse tree produced by the `userPrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	exitUserPrincipal?: (ctx: UserPrincipalContext) => void;

	/**
	 * Enter a parse tree produced by the `rolePrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	enterRolePrincipal?: (ctx: RolePrincipalContext) => void;
	/**
	 * Exit a parse tree produced by the `rolePrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	exitRolePrincipal?: (ctx: RolePrincipalContext) => void;

	/**
	 * Enter a parse tree produced by the `unspecifiedPrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	enterUnspecifiedPrincipal?: (ctx: UnspecifiedPrincipalContext) => void;
	/**
	 * Exit a parse tree produced by the `unspecifiedPrincipal`
	 * labeled alternative in `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	exitUnspecifiedPrincipal?: (ctx: UnspecifiedPrincipalContext) => void;

	/**
	 * Enter a parse tree produced by the `unboundedFrame`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	enterUnboundedFrame?: (ctx: UnboundedFrameContext) => void;
	/**
	 * Exit a parse tree produced by the `unboundedFrame`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	exitUnboundedFrame?: (ctx: UnboundedFrameContext) => void;

	/**
	 * Enter a parse tree produced by the `currentRowBound`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	enterCurrentRowBound?: (ctx: CurrentRowBoundContext) => void;
	/**
	 * Exit a parse tree produced by the `currentRowBound`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	exitCurrentRowBound?: (ctx: CurrentRowBoundContext) => void;

	/**
	 * Enter a parse tree produced by the `boundedFrame`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	enterBoundedFrame?: (ctx: BoundedFrameContext) => void;
	/**
	 * Exit a parse tree produced by the `boundedFrame`
	 * labeled alternative in `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	exitBoundedFrame?: (ctx: BoundedFrameContext) => void;

	/**
	 * Enter a parse tree produced by the `statementDefault`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterStatementDefault?: (ctx: StatementDefaultContext) => void;
	/**
	 * Exit a parse tree produced by the `statementDefault`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitStatementDefault?: (ctx: StatementDefaultContext) => void;

	/**
	 * Enter a parse tree produced by the `use`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterUse?: (ctx: UseContext) => void;
	/**
	 * Exit a parse tree produced by the `use`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitUse?: (ctx: UseContext) => void;

	/**
	 * Enter a parse tree produced by the `createSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateSchema?: (ctx: CreateSchemaContext) => void;
	/**
	 * Exit a parse tree produced by the `createSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateSchema?: (ctx: CreateSchemaContext) => void;

	/**
	 * Enter a parse tree produced by the `dropSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropSchema?: (ctx: DropSchemaContext) => void;
	/**
	 * Exit a parse tree produced by the `dropSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropSchema?: (ctx: DropSchemaContext) => void;

	/**
	 * Enter a parse tree produced by the `renameSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRenameSchema?: (ctx: RenameSchemaContext) => void;
	/**
	 * Exit a parse tree produced by the `renameSchema`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRenameSchema?: (ctx: RenameSchemaContext) => void;

	/**
	 * Enter a parse tree produced by the `createTableAsSelect`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateTableAsSelect?: (ctx: CreateTableAsSelectContext) => void;
	/**
	 * Exit a parse tree produced by the `createTableAsSelect`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateTableAsSelect?: (ctx: CreateTableAsSelectContext) => void;

	/**
	 * Enter a parse tree produced by the `createTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateTable?: (ctx: CreateTableContext) => void;
	/**
	 * Exit a parse tree produced by the `createTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateTable?: (ctx: CreateTableContext) => void;

	/**
	 * Enter a parse tree produced by the `dropTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropTable?: (ctx: DropTableContext) => void;
	/**
	 * Exit a parse tree produced by the `dropTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropTable?: (ctx: DropTableContext) => void;

	/**
	 * Enter a parse tree produced by the `insertInto`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterInsertInto?: (ctx: InsertIntoContext) => void;
	/**
	 * Exit a parse tree produced by the `insertInto`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitInsertInto?: (ctx: InsertIntoContext) => void;

	/**
	 * Enter a parse tree produced by the `update`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterUpdate?: (ctx: UpdateContext) => void;
	/**
	 * Exit a parse tree produced by the `update`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitUpdate?: (ctx: UpdateContext) => void;

	/**
	 * Enter a parse tree produced by the `delete`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDelete?: (ctx: DeleteContext) => void;
	/**
	 * Exit a parse tree produced by the `delete`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDelete?: (ctx: DeleteContext) => void;

	/**
	 * Enter a parse tree produced by the `renameTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRenameTable?: (ctx: RenameTableContext) => void;
	/**
	 * Exit a parse tree produced by the `renameTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRenameTable?: (ctx: RenameTableContext) => void;

	/**
	 * Enter a parse tree produced by the `renameColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRenameColumn?: (ctx: RenameColumnContext) => void;
	/**
	 * Exit a parse tree produced by the `renameColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRenameColumn?: (ctx: RenameColumnContext) => void;

	/**
	 * Enter a parse tree produced by the `dropColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropColumn?: (ctx: DropColumnContext) => void;
	/**
	 * Exit a parse tree produced by the `dropColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropColumn?: (ctx: DropColumnContext) => void;

	/**
	 * Enter a parse tree produced by the `addColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterAddColumn?: (ctx: AddColumnContext) => void;
	/**
	 * Exit a parse tree produced by the `addColumn`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitAddColumn?: (ctx: AddColumnContext) => void;

	/**
	 * Enter a parse tree produced by the `analyze`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterAnalyze?: (ctx: AnalyzeContext) => void;
	/**
	 * Exit a parse tree produced by the `analyze`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitAnalyze?: (ctx: AnalyzeContext) => void;

	/**
	 * Enter a parse tree produced by the `createType`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateType?: (ctx: CreateTypeContext) => void;
	/**
	 * Exit a parse tree produced by the `createType`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateType?: (ctx: CreateTypeContext) => void;

	/**
	 * Enter a parse tree produced by the `createView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateView?: (ctx: CreateViewContext) => void;
	/**
	 * Exit a parse tree produced by the `createView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateView?: (ctx: CreateViewContext) => void;

	/**
	 * Enter a parse tree produced by the `dropView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropView?: (ctx: DropViewContext) => void;
	/**
	 * Exit a parse tree produced by the `dropView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropView?: (ctx: DropViewContext) => void;

	/**
	 * Enter a parse tree produced by the `createMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateMaterializedView?: (ctx: CreateMaterializedViewContext) => void;
	/**
	 * Exit a parse tree produced by the `createMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateMaterializedView?: (ctx: CreateMaterializedViewContext) => void;

	/**
	 * Enter a parse tree produced by the `dropMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropMaterializedView?: (ctx: DropMaterializedViewContext) => void;
	/**
	 * Exit a parse tree produced by the `dropMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropMaterializedView?: (ctx: DropMaterializedViewContext) => void;

	/**
	 * Enter a parse tree produced by the `refreshMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRefreshMaterializedView?: (ctx: RefreshMaterializedViewContext) => void;
	/**
	 * Exit a parse tree produced by the `refreshMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRefreshMaterializedView?: (ctx: RefreshMaterializedViewContext) => void;

	/**
	 * Enter a parse tree produced by the `createFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateFunction?: (ctx: CreateFunctionContext) => void;
	/**
	 * Exit a parse tree produced by the `createFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateFunction?: (ctx: CreateFunctionContext) => void;

	/**
	 * Enter a parse tree produced by the `alterFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterAlterFunction?: (ctx: AlterFunctionContext) => void;
	/**
	 * Exit a parse tree produced by the `alterFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitAlterFunction?: (ctx: AlterFunctionContext) => void;

	/**
	 * Enter a parse tree produced by the `dropFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropFunction?: (ctx: DropFunctionContext) => void;
	/**
	 * Exit a parse tree produced by the `dropFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropFunction?: (ctx: DropFunctionContext) => void;

	/**
	 * Enter a parse tree produced by the `call`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCall?: (ctx: CallContext) => void;
	/**
	 * Exit a parse tree produced by the `call`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCall?: (ctx: CallContext) => void;

	/**
	 * Enter a parse tree produced by the `createRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCreateRole?: (ctx: CreateRoleContext) => void;
	/**
	 * Exit a parse tree produced by the `createRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCreateRole?: (ctx: CreateRoleContext) => void;

	/**
	 * Enter a parse tree produced by the `dropRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDropRole?: (ctx: DropRoleContext) => void;
	/**
	 * Exit a parse tree produced by the `dropRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDropRole?: (ctx: DropRoleContext) => void;

	/**
	 * Enter a parse tree produced by the `grantRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterGrantRoles?: (ctx: GrantRolesContext) => void;
	/**
	 * Exit a parse tree produced by the `grantRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitGrantRoles?: (ctx: GrantRolesContext) => void;

	/**
	 * Enter a parse tree produced by the `revokeRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRevokeRoles?: (ctx: RevokeRolesContext) => void;
	/**
	 * Exit a parse tree produced by the `revokeRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRevokeRoles?: (ctx: RevokeRolesContext) => void;

	/**
	 * Enter a parse tree produced by the `setRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterSetRole?: (ctx: SetRoleContext) => void;
	/**
	 * Exit a parse tree produced by the `setRole`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitSetRole?: (ctx: SetRoleContext) => void;

	/**
	 * Enter a parse tree produced by the `grant`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterGrant?: (ctx: GrantContext) => void;
	/**
	 * Exit a parse tree produced by the `grant`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitGrant?: (ctx: GrantContext) => void;

	/**
	 * Enter a parse tree produced by the `revoke`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRevoke?: (ctx: RevokeContext) => void;
	/**
	 * Exit a parse tree produced by the `revoke`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRevoke?: (ctx: RevokeContext) => void;

	/**
	 * Enter a parse tree produced by the `showGrants`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowGrants?: (ctx: ShowGrantsContext) => void;
	/**
	 * Exit a parse tree produced by the `showGrants`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowGrants?: (ctx: ShowGrantsContext) => void;

	/**
	 * Enter a parse tree produced by the `explain`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterExplain?: (ctx: ExplainContext) => void;
	/**
	 * Exit a parse tree produced by the `explain`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitExplain?: (ctx: ExplainContext) => void;

	/**
	 * Enter a parse tree produced by the `showCreateTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowCreateTable?: (ctx: ShowCreateTableContext) => void;
	/**
	 * Exit a parse tree produced by the `showCreateTable`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowCreateTable?: (ctx: ShowCreateTableContext) => void;

	/**
	 * Enter a parse tree produced by the `showCreateView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowCreateView?: (ctx: ShowCreateViewContext) => void;
	/**
	 * Exit a parse tree produced by the `showCreateView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowCreateView?: (ctx: ShowCreateViewContext) => void;

	/**
	 * Enter a parse tree produced by the `showCreateMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowCreateMaterializedView?: (ctx: ShowCreateMaterializedViewContext) => void;
	/**
	 * Exit a parse tree produced by the `showCreateMaterializedView`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowCreateMaterializedView?: (ctx: ShowCreateMaterializedViewContext) => void;

	/**
	 * Enter a parse tree produced by the `showCreateFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowCreateFunction?: (ctx: ShowCreateFunctionContext) => void;
	/**
	 * Exit a parse tree produced by the `showCreateFunction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowCreateFunction?: (ctx: ShowCreateFunctionContext) => void;

	/**
	 * Enter a parse tree produced by the `showTables`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowTables?: (ctx: ShowTablesContext) => void;
	/**
	 * Exit a parse tree produced by the `showTables`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowTables?: (ctx: ShowTablesContext) => void;

	/**
	 * Enter a parse tree produced by the `showSchemas`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowSchemas?: (ctx: ShowSchemasContext) => void;
	/**
	 * Exit a parse tree produced by the `showSchemas`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowSchemas?: (ctx: ShowSchemasContext) => void;

	/**
	 * Enter a parse tree produced by the `showCatalogs`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowCatalogs?: (ctx: ShowCatalogsContext) => void;
	/**
	 * Exit a parse tree produced by the `showCatalogs`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowCatalogs?: (ctx: ShowCatalogsContext) => void;

	/**
	 * Enter a parse tree produced by the `showColumns`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowColumns?: (ctx: ShowColumnsContext) => void;
	/**
	 * Exit a parse tree produced by the `showColumns`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowColumns?: (ctx: ShowColumnsContext) => void;

	/**
	 * Enter a parse tree produced by the `showStats`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowStats?: (ctx: ShowStatsContext) => void;
	/**
	 * Exit a parse tree produced by the `showStats`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowStats?: (ctx: ShowStatsContext) => void;

	/**
	 * Enter a parse tree produced by the `showStatsForQuery`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowStatsForQuery?: (ctx: ShowStatsForQueryContext) => void;
	/**
	 * Exit a parse tree produced by the `showStatsForQuery`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowStatsForQuery?: (ctx: ShowStatsForQueryContext) => void;

	/**
	 * Enter a parse tree produced by the `showRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowRoles?: (ctx: ShowRolesContext) => void;
	/**
	 * Exit a parse tree produced by the `showRoles`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowRoles?: (ctx: ShowRolesContext) => void;

	/**
	 * Enter a parse tree produced by the `showRoleGrants`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowRoleGrants?: (ctx: ShowRoleGrantsContext) => void;
	/**
	 * Exit a parse tree produced by the `showRoleGrants`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowRoleGrants?: (ctx: ShowRoleGrantsContext) => void;

	/**
	 * Enter a parse tree produced by the `showFunctions`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowFunctions?: (ctx: ShowFunctionsContext) => void;
	/**
	 * Exit a parse tree produced by the `showFunctions`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowFunctions?: (ctx: ShowFunctionsContext) => void;

	/**
	 * Enter a parse tree produced by the `showSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterShowSession?: (ctx: ShowSessionContext) => void;
	/**
	 * Exit a parse tree produced by the `showSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitShowSession?: (ctx: ShowSessionContext) => void;

	/**
	 * Enter a parse tree produced by the `setSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterSetSession?: (ctx: SetSessionContext) => void;
	/**
	 * Exit a parse tree produced by the `setSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitSetSession?: (ctx: SetSessionContext) => void;

	/**
	 * Enter a parse tree produced by the `resetSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterResetSession?: (ctx: ResetSessionContext) => void;
	/**
	 * Exit a parse tree produced by the `resetSession`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitResetSession?: (ctx: ResetSessionContext) => void;

	/**
	 * Enter a parse tree produced by the `startTransaction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterStartTransaction?: (ctx: StartTransactionContext) => void;
	/**
	 * Exit a parse tree produced by the `startTransaction`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitStartTransaction?: (ctx: StartTransactionContext) => void;

	/**
	 * Enter a parse tree produced by the `commit`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterCommit?: (ctx: CommitContext) => void;
	/**
	 * Exit a parse tree produced by the `commit`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitCommit?: (ctx: CommitContext) => void;

	/**
	 * Enter a parse tree produced by the `rollback`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterRollback?: (ctx: RollbackContext) => void;
	/**
	 * Exit a parse tree produced by the `rollback`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitRollback?: (ctx: RollbackContext) => void;

	/**
	 * Enter a parse tree produced by the `prepare`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterPrepare?: (ctx: PrepareContext) => void;
	/**
	 * Exit a parse tree produced by the `prepare`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitPrepare?: (ctx: PrepareContext) => void;

	/**
	 * Enter a parse tree produced by the `deallocate`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDeallocate?: (ctx: DeallocateContext) => void;
	/**
	 * Exit a parse tree produced by the `deallocate`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDeallocate?: (ctx: DeallocateContext) => void;

	/**
	 * Enter a parse tree produced by the `execute`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterExecute?: (ctx: ExecuteContext) => void;
	/**
	 * Exit a parse tree produced by the `execute`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitExecute?: (ctx: ExecuteContext) => void;

	/**
	 * Enter a parse tree produced by the `describeInput`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDescribeInput?: (ctx: DescribeInputContext) => void;
	/**
	 * Exit a parse tree produced by the `describeInput`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDescribeInput?: (ctx: DescribeInputContext) => void;

	/**
	 * Enter a parse tree produced by the `describeOutput`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterDescribeOutput?: (ctx: DescribeOutputContext) => void;
	/**
	 * Exit a parse tree produced by the `describeOutput`
	 * labeled alternative in `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitDescribeOutput?: (ctx: DescribeOutputContext) => void;

	/**
	 * Enter a parse tree produced by the `timeZoneInterval`
	 * labeled alternative in `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	enterTimeZoneInterval?: (ctx: TimeZoneIntervalContext) => void;
	/**
	 * Exit a parse tree produced by the `timeZoneInterval`
	 * labeled alternative in `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	exitTimeZoneInterval?: (ctx: TimeZoneIntervalContext) => void;

	/**
	 * Enter a parse tree produced by the `timeZoneString`
	 * labeled alternative in `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	enterTimeZoneString?: (ctx: TimeZoneStringContext) => void;
	/**
	 * Exit a parse tree produced by the `timeZoneString`
	 * labeled alternative in `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	exitTimeZoneString?: (ctx: TimeZoneStringContext) => void;

	/**
	 * Enter a parse tree produced by the `queryPrimaryDefault`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	enterQueryPrimaryDefault?: (ctx: QueryPrimaryDefaultContext) => void;
	/**
	 * Exit a parse tree produced by the `queryPrimaryDefault`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	exitQueryPrimaryDefault?: (ctx: QueryPrimaryDefaultContext) => void;

	/**
	 * Enter a parse tree produced by the `table`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	enterTable?: (ctx: TableContext) => void;
	/**
	 * Exit a parse tree produced by the `table`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	exitTable?: (ctx: TableContext) => void;

	/**
	 * Enter a parse tree produced by the `inlineTable`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	enterInlineTable?: (ctx: InlineTableContext) => void;
	/**
	 * Exit a parse tree produced by the `inlineTable`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	exitInlineTable?: (ctx: InlineTableContext) => void;

	/**
	 * Enter a parse tree produced by the `subquery`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	enterSubquery?: (ctx: SubqueryContext) => void;
	/**
	 * Exit a parse tree produced by the `subquery`
	 * labeled alternative in `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	exitSubquery?: (ctx: SubqueryContext) => void;

	/**
	 * Enter a parse tree produced by the `nullLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterNullLiteral?: (ctx: NullLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `nullLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitNullLiteral?: (ctx: NullLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `intervalLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterIntervalLiteral?: (ctx: IntervalLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `intervalLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitIntervalLiteral?: (ctx: IntervalLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `typeConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterTypeConstructor?: (ctx: TypeConstructorContext) => void;
	/**
	 * Exit a parse tree produced by the `typeConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitTypeConstructor?: (ctx: TypeConstructorContext) => void;

	/**
	 * Enter a parse tree produced by the `numericLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterNumericLiteral?: (ctx: NumericLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `numericLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitNumericLiteral?: (ctx: NumericLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `booleanLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterBooleanLiteral?: (ctx: BooleanLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `booleanLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitBooleanLiteral?: (ctx: BooleanLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `stringLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterStringLiteral?: (ctx: StringLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `stringLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitStringLiteral?: (ctx: StringLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `binaryLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterBinaryLiteral?: (ctx: BinaryLiteralContext) => void;
	/**
	 * Exit a parse tree produced by the `binaryLiteral`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitBinaryLiteral?: (ctx: BinaryLiteralContext) => void;

	/**
	 * Enter a parse tree produced by the `parameter`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterParameter?: (ctx: ParameterContext) => void;
	/**
	 * Exit a parse tree produced by the `parameter`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitParameter?: (ctx: ParameterContext) => void;

	/**
	 * Enter a parse tree produced by the `position`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterPosition?: (ctx: PositionContext) => void;
	/**
	 * Exit a parse tree produced by the `position`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitPosition?: (ctx: PositionContext) => void;

	/**
	 * Enter a parse tree produced by the `rowConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterRowConstructor?: (ctx: RowConstructorContext) => void;
	/**
	 * Exit a parse tree produced by the `rowConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitRowConstructor?: (ctx: RowConstructorContext) => void;

	/**
	 * Enter a parse tree produced by the `functionCall`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterFunctionCall?: (ctx: FunctionCallContext) => void;
	/**
	 * Exit a parse tree produced by the `functionCall`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitFunctionCall?: (ctx: FunctionCallContext) => void;

	/**
	 * Enter a parse tree produced by the `lambda`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterLambda?: (ctx: LambdaContext) => void;
	/**
	 * Exit a parse tree produced by the `lambda`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitLambda?: (ctx: LambdaContext) => void;

	/**
	 * Enter a parse tree produced by the `subqueryExpression`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSubqueryExpression?: (ctx: SubqueryExpressionContext) => void;
	/**
	 * Exit a parse tree produced by the `subqueryExpression`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSubqueryExpression?: (ctx: SubqueryExpressionContext) => void;

	/**
	 * Enter a parse tree produced by the `exists`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterExists?: (ctx: ExistsContext) => void;
	/**
	 * Exit a parse tree produced by the `exists`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitExists?: (ctx: ExistsContext) => void;

	/**
	 * Enter a parse tree produced by the `simpleCase`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSimpleCase?: (ctx: SimpleCaseContext) => void;
	/**
	 * Exit a parse tree produced by the `simpleCase`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSimpleCase?: (ctx: SimpleCaseContext) => void;

	/**
	 * Enter a parse tree produced by the `searchedCase`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSearchedCase?: (ctx: SearchedCaseContext) => void;
	/**
	 * Exit a parse tree produced by the `searchedCase`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSearchedCase?: (ctx: SearchedCaseContext) => void;

	/**
	 * Enter a parse tree produced by the `cast`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterCast?: (ctx: CastContext) => void;
	/**
	 * Exit a parse tree produced by the `cast`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitCast?: (ctx: CastContext) => void;

	/**
	 * Enter a parse tree produced by the `arrayConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterArrayConstructor?: (ctx: ArrayConstructorContext) => void;
	/**
	 * Exit a parse tree produced by the `arrayConstructor`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitArrayConstructor?: (ctx: ArrayConstructorContext) => void;

	/**
	 * Enter a parse tree produced by the `subscript`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSubscript?: (ctx: SubscriptContext) => void;
	/**
	 * Exit a parse tree produced by the `subscript`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSubscript?: (ctx: SubscriptContext) => void;

	/**
	 * Enter a parse tree produced by the `columnReference`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterColumnReference?: (ctx: ColumnReferenceContext) => void;
	/**
	 * Exit a parse tree produced by the `columnReference`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitColumnReference?: (ctx: ColumnReferenceContext) => void;

	/**
	 * Enter a parse tree produced by the `dereference`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterDereference?: (ctx: DereferenceContext) => void;
	/**
	 * Exit a parse tree produced by the `dereference`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitDereference?: (ctx: DereferenceContext) => void;

	/**
	 * Enter a parse tree produced by the `specialDateTimeFunction`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSpecialDateTimeFunction?: (ctx: SpecialDateTimeFunctionContext) => void;
	/**
	 * Exit a parse tree produced by the `specialDateTimeFunction`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSpecialDateTimeFunction?: (ctx: SpecialDateTimeFunctionContext) => void;

	/**
	 * Enter a parse tree produced by the `currentUser`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterCurrentUser?: (ctx: CurrentUserContext) => void;
	/**
	 * Exit a parse tree produced by the `currentUser`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitCurrentUser?: (ctx: CurrentUserContext) => void;

	/**
	 * Enter a parse tree produced by the `substring`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterSubstring?: (ctx: SubstringContext) => void;
	/**
	 * Exit a parse tree produced by the `substring`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitSubstring?: (ctx: SubstringContext) => void;

	/**
	 * Enter a parse tree produced by the `normalize`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterNormalize?: (ctx: NormalizeContext) => void;
	/**
	 * Exit a parse tree produced by the `normalize`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitNormalize?: (ctx: NormalizeContext) => void;

	/**
	 * Enter a parse tree produced by the `extract`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterExtract?: (ctx: ExtractContext) => void;
	/**
	 * Exit a parse tree produced by the `extract`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitExtract?: (ctx: ExtractContext) => void;

	/**
	 * Enter a parse tree produced by the `parenthesizedExpression`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterParenthesizedExpression?: (ctx: ParenthesizedExpressionContext) => void;
	/**
	 * Exit a parse tree produced by the `parenthesizedExpression`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitParenthesizedExpression?: (ctx: ParenthesizedExpressionContext) => void;

	/**
	 * Enter a parse tree produced by the `groupingOperation`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterGroupingOperation?: (ctx: GroupingOperationContext) => void;
	/**
	 * Exit a parse tree produced by the `groupingOperation`
	 * labeled alternative in `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitGroupingOperation?: (ctx: GroupingOperationContext) => void;

	/**
	 * Enter a parse tree produced by the `isolationLevel`
	 * labeled alternative in `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	enterIsolationLevel?: (ctx: IsolationLevelContext) => void;
	/**
	 * Exit a parse tree produced by the `isolationLevel`
	 * labeled alternative in `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	exitIsolationLevel?: (ctx: IsolationLevelContext) => void;

	/**
	 * Enter a parse tree produced by the `transactionAccessMode`
	 * labeled alternative in `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	enterTransactionAccessMode?: (ctx: TransactionAccessModeContext) => void;
	/**
	 * Exit a parse tree produced by the `transactionAccessMode`
	 * labeled alternative in `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	exitTransactionAccessMode?: (ctx: TransactionAccessModeContext) => void;

	/**
	 * Enter a parse tree produced by the `select`
	 * labeled alternative in `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	enterSelect?: (ctx: SelectContext) => void;
	/**
	 * Exit a parse tree produced by the `select`
	 * labeled alternative in `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	exitSelect?: (ctx: SelectContext) => void;

	/**
	 * Enter a parse tree produced by the `selectAll`
	 * labeled alternative in `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	enterSelectAll?: (ctx: SelectAllContext) => void;
	/**
	 * Exit a parse tree produced by the `selectAll`
	 * labeled alternative in `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	exitSelectAll?: (ctx: SelectAllContext) => void;

	/**
	 * Enter a parse tree produced by the `predicated`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	enterPredicated?: (ctx: PredicatedContext) => void;
	/**
	 * Exit a parse tree produced by the `predicated`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	exitPredicated?: (ctx: PredicatedContext) => void;

	/**
	 * Enter a parse tree produced by the `logicalNot`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	enterLogicalNot?: (ctx: LogicalNotContext) => void;
	/**
	 * Exit a parse tree produced by the `logicalNot`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	exitLogicalNot?: (ctx: LogicalNotContext) => void;

	/**
	 * Enter a parse tree produced by the `logicalBinary`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	enterLogicalBinary?: (ctx: LogicalBinaryContext) => void;
	/**
	 * Exit a parse tree produced by the `logicalBinary`
	 * labeled alternative in `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	exitLogicalBinary?: (ctx: LogicalBinaryContext) => void;

	/**
	 * Enter a parse tree produced by the `positionalArgument`
	 * labeled alternative in `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	enterPositionalArgument?: (ctx: PositionalArgumentContext) => void;
	/**
	 * Exit a parse tree produced by the `positionalArgument`
	 * labeled alternative in `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	exitPositionalArgument?: (ctx: PositionalArgumentContext) => void;

	/**
	 * Enter a parse tree produced by the `namedArgument`
	 * labeled alternative in `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	enterNamedArgument?: (ctx: NamedArgumentContext) => void;
	/**
	 * Exit a parse tree produced by the `namedArgument`
	 * labeled alternative in `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	exitNamedArgument?: (ctx: NamedArgumentContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.singleStatement`.
	 * @param ctx the parse tree
	 */
	enterSingleStatement?: (ctx: SingleStatementContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.singleStatement`.
	 * @param ctx the parse tree
	 */
	exitSingleStatement?: (ctx: SingleStatementContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.standaloneExpression`.
	 * @param ctx the parse tree
	 */
	enterStandaloneExpression?: (ctx: StandaloneExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.standaloneExpression`.
	 * @param ctx the parse tree
	 */
	exitStandaloneExpression?: (ctx: StandaloneExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.standaloneRoutineBody`.
	 * @param ctx the parse tree
	 */
	enterStandaloneRoutineBody?: (ctx: StandaloneRoutineBodyContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.standaloneRoutineBody`.
	 * @param ctx the parse tree
	 */
	exitStandaloneRoutineBody?: (ctx: StandaloneRoutineBodyContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	enterStatement?: (ctx: StatementContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.statement`.
	 * @param ctx the parse tree
	 */
	exitStatement?: (ctx: StatementContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.query`.
	 * @param ctx the parse tree
	 */
	enterQuery?: (ctx: QueryContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.query`.
	 * @param ctx the parse tree
	 */
	exitQuery?: (ctx: QueryContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.queryWith`.
	 * @param ctx the parse tree
	 */
	enterQueryWith?: (ctx: QueryWithContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.queryWith`.
	 * @param ctx the parse tree
	 */
	exitQueryWith?: (ctx: QueryWithContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.tableElement`.
	 * @param ctx the parse tree
	 */
	enterTableElement?: (ctx: TableElementContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.tableElement`.
	 * @param ctx the parse tree
	 */
	exitTableElement?: (ctx: TableElementContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.columnDefinition`.
	 * @param ctx the parse tree
	 */
	enterColumnDefinition?: (ctx: ColumnDefinitionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.columnDefinition`.
	 * @param ctx the parse tree
	 */
	exitColumnDefinition?: (ctx: ColumnDefinitionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.likeClause`.
	 * @param ctx the parse tree
	 */
	enterLikeClause?: (ctx: LikeClauseContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.likeClause`.
	 * @param ctx the parse tree
	 */
	exitLikeClause?: (ctx: LikeClauseContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.properties`.
	 * @param ctx the parse tree
	 */
	enterProperties?: (ctx: PropertiesContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.properties`.
	 * @param ctx the parse tree
	 */
	exitProperties?: (ctx: PropertiesContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.property`.
	 * @param ctx the parse tree
	 */
	enterProperty?: (ctx: PropertyContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.property`.
	 * @param ctx the parse tree
	 */
	exitProperty?: (ctx: PropertyContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.sqlParameterDeclaration`.
	 * @param ctx the parse tree
	 */
	enterSqlParameterDeclaration?: (ctx: SqlParameterDeclarationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.sqlParameterDeclaration`.
	 * @param ctx the parse tree
	 */
	exitSqlParameterDeclaration?: (ctx: SqlParameterDeclarationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.routineCharacteristics`.
	 * @param ctx the parse tree
	 */
	enterRoutineCharacteristics?: (ctx: RoutineCharacteristicsContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.routineCharacteristics`.
	 * @param ctx the parse tree
	 */
	exitRoutineCharacteristics?: (ctx: RoutineCharacteristicsContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.routineCharacteristic`.
	 * @param ctx the parse tree
	 */
	enterRoutineCharacteristic?: (ctx: RoutineCharacteristicContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.routineCharacteristic`.
	 * @param ctx the parse tree
	 */
	exitRoutineCharacteristic?: (ctx: RoutineCharacteristicContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.alterRoutineCharacteristics`.
	 * @param ctx the parse tree
	 */
	enterAlterRoutineCharacteristics?: (ctx: AlterRoutineCharacteristicsContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.alterRoutineCharacteristics`.
	 * @param ctx the parse tree
	 */
	exitAlterRoutineCharacteristics?: (ctx: AlterRoutineCharacteristicsContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.alterRoutineCharacteristic`.
	 * @param ctx the parse tree
	 */
	enterAlterRoutineCharacteristic?: (ctx: AlterRoutineCharacteristicContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.alterRoutineCharacteristic`.
	 * @param ctx the parse tree
	 */
	exitAlterRoutineCharacteristic?: (ctx: AlterRoutineCharacteristicContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.routineBody`.
	 * @param ctx the parse tree
	 */
	enterRoutineBody?: (ctx: RoutineBodyContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.routineBody`.
	 * @param ctx the parse tree
	 */
	exitRoutineBody?: (ctx: RoutineBodyContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.returnStatement`.
	 * @param ctx the parse tree
	 */
	enterReturnStatement?: (ctx: ReturnStatementContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.returnStatement`.
	 * @param ctx the parse tree
	 */
	exitReturnStatement?: (ctx: ReturnStatementContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.externalBodyReference`.
	 * @param ctx the parse tree
	 */
	enterExternalBodyReference?: (ctx: ExternalBodyReferenceContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.externalBodyReference`.
	 * @param ctx the parse tree
	 */
	exitExternalBodyReference?: (ctx: ExternalBodyReferenceContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.language`.
	 * @param ctx the parse tree
	 */
	enterLanguage?: (ctx: LanguageContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.language`.
	 * @param ctx the parse tree
	 */
	exitLanguage?: (ctx: LanguageContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.determinism`.
	 * @param ctx the parse tree
	 */
	enterDeterminism?: (ctx: DeterminismContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.determinism`.
	 * @param ctx the parse tree
	 */
	exitDeterminism?: (ctx: DeterminismContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.nullCallClause`.
	 * @param ctx the parse tree
	 */
	enterNullCallClause?: (ctx: NullCallClauseContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.nullCallClause`.
	 * @param ctx the parse tree
	 */
	exitNullCallClause?: (ctx: NullCallClauseContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.externalRoutineName`.
	 * @param ctx the parse tree
	 */
	enterExternalRoutineName?: (ctx: ExternalRoutineNameContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.externalRoutineName`.
	 * @param ctx the parse tree
	 */
	exitExternalRoutineName?: (ctx: ExternalRoutineNameContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.queryNoWith`.
	 * @param ctx the parse tree
	 */
	enterQueryNoWith?: (ctx: QueryNoWithContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.queryNoWith`.
	 * @param ctx the parse tree
	 */
	exitQueryNoWith?: (ctx: QueryNoWithContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	enterQueryTerm?: (ctx: QueryTermContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.queryTerm`.
	 * @param ctx the parse tree
	 */
	exitQueryTerm?: (ctx: QueryTermContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	enterQueryPrimary?: (ctx: QueryPrimaryContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.queryPrimary`.
	 * @param ctx the parse tree
	 */
	exitQueryPrimary?: (ctx: QueryPrimaryContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.sortItem`.
	 * @param ctx the parse tree
	 */
	enterSortItem?: (ctx: SortItemContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.sortItem`.
	 * @param ctx the parse tree
	 */
	exitSortItem?: (ctx: SortItemContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.querySpecification`.
	 * @param ctx the parse tree
	 */
	enterQuerySpecification?: (ctx: QuerySpecificationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.querySpecification`.
	 * @param ctx the parse tree
	 */
	exitQuerySpecification?: (ctx: QuerySpecificationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.groupBy`.
	 * @param ctx the parse tree
	 */
	enterGroupBy?: (ctx: GroupByContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.groupBy`.
	 * @param ctx the parse tree
	 */
	exitGroupBy?: (ctx: GroupByContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	enterGroupingElement?: (ctx: GroupingElementContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.groupingElement`.
	 * @param ctx the parse tree
	 */
	exitGroupingElement?: (ctx: GroupingElementContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.groupingSet`.
	 * @param ctx the parse tree
	 */
	enterGroupingSet?: (ctx: GroupingSetContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.groupingSet`.
	 * @param ctx the parse tree
	 */
	exitGroupingSet?: (ctx: GroupingSetContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.namedQuery`.
	 * @param ctx the parse tree
	 */
	enterNamedQuery?: (ctx: NamedQueryContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.namedQuery`.
	 * @param ctx the parse tree
	 */
	exitNamedQuery?: (ctx: NamedQueryContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.setQuantifier`.
	 * @param ctx the parse tree
	 */
	enterSetQuantifier?: (ctx: SetQuantifierContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.setQuantifier`.
	 * @param ctx the parse tree
	 */
	exitSetQuantifier?: (ctx: SetQuantifierContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	enterSelectItem?: (ctx: SelectItemContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.selectItem`.
	 * @param ctx the parse tree
	 */
	exitSelectItem?: (ctx: SelectItemContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	enterRelation?: (ctx: RelationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.relation`.
	 * @param ctx the parse tree
	 */
	exitRelation?: (ctx: RelationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.joinType`.
	 * @param ctx the parse tree
	 */
	enterJoinType?: (ctx: JoinTypeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.joinType`.
	 * @param ctx the parse tree
	 */
	exitJoinType?: (ctx: JoinTypeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.joinCriteria`.
	 * @param ctx the parse tree
	 */
	enterJoinCriteria?: (ctx: JoinCriteriaContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.joinCriteria`.
	 * @param ctx the parse tree
	 */
	exitJoinCriteria?: (ctx: JoinCriteriaContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.sampledRelation`.
	 * @param ctx the parse tree
	 */
	enterSampledRelation?: (ctx: SampledRelationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.sampledRelation`.
	 * @param ctx the parse tree
	 */
	exitSampledRelation?: (ctx: SampledRelationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.sampleType`.
	 * @param ctx the parse tree
	 */
	enterSampleType?: (ctx: SampleTypeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.sampleType`.
	 * @param ctx the parse tree
	 */
	exitSampleType?: (ctx: SampleTypeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.aliasedRelation`.
	 * @param ctx the parse tree
	 */
	enterAliasedRelation?: (ctx: AliasedRelationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.aliasedRelation`.
	 * @param ctx the parse tree
	 */
	exitAliasedRelation?: (ctx: AliasedRelationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.columnAliases`.
	 * @param ctx the parse tree
	 */
	enterColumnAliases?: (ctx: ColumnAliasesContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.columnAliases`.
	 * @param ctx the parse tree
	 */
	exitColumnAliases?: (ctx: ColumnAliasesContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	enterRelationPrimary?: (ctx: RelationPrimaryContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.relationPrimary`.
	 * @param ctx the parse tree
	 */
	exitRelationPrimary?: (ctx: RelationPrimaryContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.expression`.
	 * @param ctx the parse tree
	 */
	enterExpression?: (ctx: ExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.expression`.
	 * @param ctx the parse tree
	 */
	exitExpression?: (ctx: ExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.whereExpression`.
	 * @param ctx the parse tree
	 */
	enterWhereExpression?: (ctx: WhereExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.whereExpression`.
	 * @param ctx the parse tree
	 */
	exitWhereExpression?: (ctx: WhereExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.updateExpression`.
	 * @param ctx the parse tree
	 */
	enterUpdateExpression?: (ctx: UpdateExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.updateExpression`.
	 * @param ctx the parse tree
	 */
	exitUpdateExpression?: (ctx: UpdateExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.havingExpression`.
	 * @param ctx the parse tree
	 */
	enterHavingExpression?: (ctx: HavingExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.havingExpression`.
	 * @param ctx the parse tree
	 */
	exitHavingExpression?: (ctx: HavingExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	enterBooleanExpression?: (ctx: BooleanExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.booleanExpression`.
	 * @param ctx the parse tree
	 */
	exitBooleanExpression?: (ctx: BooleanExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	enterPredicate?: (ctx: PredicateContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.predicate`.
	 * @param ctx the parse tree
	 */
	exitPredicate?: (ctx: PredicateContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	enterValueExpression?: (ctx: ValueExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.valueExpression`.
	 * @param ctx the parse tree
	 */
	exitValueExpression?: (ctx: ValueExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	enterPrimaryExpression?: (ctx: PrimaryExpressionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.primaryExpression`.
	 * @param ctx the parse tree
	 */
	exitPrimaryExpression?: (ctx: PrimaryExpressionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	enterString?: (ctx: StringContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.string`.
	 * @param ctx the parse tree
	 */
	exitString?: (ctx: StringContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.nullTreatment`.
	 * @param ctx the parse tree
	 */
	enterNullTreatment?: (ctx: NullTreatmentContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.nullTreatment`.
	 * @param ctx the parse tree
	 */
	exitNullTreatment?: (ctx: NullTreatmentContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	enterTimeZoneSpecifier?: (ctx: TimeZoneSpecifierContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.timeZoneSpecifier`.
	 * @param ctx the parse tree
	 */
	exitTimeZoneSpecifier?: (ctx: TimeZoneSpecifierContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.comparisonOperator`.
	 * @param ctx the parse tree
	 */
	enterComparisonOperator?: (ctx: ComparisonOperatorContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.comparisonOperator`.
	 * @param ctx the parse tree
	 */
	exitComparisonOperator?: (ctx: ComparisonOperatorContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.comparisonQuantifier`.
	 * @param ctx the parse tree
	 */
	enterComparisonQuantifier?: (ctx: ComparisonQuantifierContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.comparisonQuantifier`.
	 * @param ctx the parse tree
	 */
	exitComparisonQuantifier?: (ctx: ComparisonQuantifierContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.booleanValue`.
	 * @param ctx the parse tree
	 */
	enterBooleanValue?: (ctx: BooleanValueContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.booleanValue`.
	 * @param ctx the parse tree
	 */
	exitBooleanValue?: (ctx: BooleanValueContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.interval`.
	 * @param ctx the parse tree
	 */
	enterInterval?: (ctx: IntervalContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.interval`.
	 * @param ctx the parse tree
	 */
	exitInterval?: (ctx: IntervalContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.intervalField`.
	 * @param ctx the parse tree
	 */
	enterIntervalField?: (ctx: IntervalFieldContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.intervalField`.
	 * @param ctx the parse tree
	 */
	exitIntervalField?: (ctx: IntervalFieldContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.normalForm`.
	 * @param ctx the parse tree
	 */
	enterNormalForm?: (ctx: NormalFormContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.normalForm`.
	 * @param ctx the parse tree
	 */
	exitNormalForm?: (ctx: NormalFormContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.types`.
	 * @param ctx the parse tree
	 */
	enterTypes?: (ctx: TypesContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.types`.
	 * @param ctx the parse tree
	 */
	exitTypes?: (ctx: TypesContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.type`.
	 * @param ctx the parse tree
	 */
	enterType?: (ctx: TypeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.type`.
	 * @param ctx the parse tree
	 */
	exitType?: (ctx: TypeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.typeParameter`.
	 * @param ctx the parse tree
	 */
	enterTypeParameter?: (ctx: TypeParameterContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.typeParameter`.
	 * @param ctx the parse tree
	 */
	exitTypeParameter?: (ctx: TypeParameterContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.baseType`.
	 * @param ctx the parse tree
	 */
	enterBaseType?: (ctx: BaseTypeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.baseType`.
	 * @param ctx the parse tree
	 */
	exitBaseType?: (ctx: BaseTypeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.whenClause`.
	 * @param ctx the parse tree
	 */
	enterWhenClause?: (ctx: WhenClauseContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.whenClause`.
	 * @param ctx the parse tree
	 */
	exitWhenClause?: (ctx: WhenClauseContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.filter`.
	 * @param ctx the parse tree
	 */
	enterFilter?: (ctx: FilterContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.filter`.
	 * @param ctx the parse tree
	 */
	exitFilter?: (ctx: FilterContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.over`.
	 * @param ctx the parse tree
	 */
	enterOver?: (ctx: OverContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.over`.
	 * @param ctx the parse tree
	 */
	exitOver?: (ctx: OverContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.windowFrame`.
	 * @param ctx the parse tree
	 */
	enterWindowFrame?: (ctx: WindowFrameContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.windowFrame`.
	 * @param ctx the parse tree
	 */
	exitWindowFrame?: (ctx: WindowFrameContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	enterFrameBound?: (ctx: FrameBoundContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.frameBound`.
	 * @param ctx the parse tree
	 */
	exitFrameBound?: (ctx: FrameBoundContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	enterExplainOption?: (ctx: ExplainOptionContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.explainOption`.
	 * @param ctx the parse tree
	 */
	exitExplainOption?: (ctx: ExplainOptionContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	enterTransactionMode?: (ctx: TransactionModeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.transactionMode`.
	 * @param ctx the parse tree
	 */
	exitTransactionMode?: (ctx: TransactionModeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	enterLevelOfIsolation?: (ctx: LevelOfIsolationContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.levelOfIsolation`.
	 * @param ctx the parse tree
	 */
	exitLevelOfIsolation?: (ctx: LevelOfIsolationContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	enterCallArgument?: (ctx: CallArgumentContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.callArgument`.
	 * @param ctx the parse tree
	 */
	exitCallArgument?: (ctx: CallArgumentContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.privilege`.
	 * @param ctx the parse tree
	 */
	enterPrivilege?: (ctx: PrivilegeContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.privilege`.
	 * @param ctx the parse tree
	 */
	exitPrivilege?: (ctx: PrivilegeContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.qualifiedName`.
	 * @param ctx the parse tree
	 */
	enterQualifiedName?: (ctx: QualifiedNameContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.qualifiedName`.
	 * @param ctx the parse tree
	 */
	exitQualifiedName?: (ctx: QualifiedNameContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.tableNameWithAliases`.
	 * @param ctx the parse tree
	 */
	enterTableNameWithAliases?: (ctx: TableNameWithAliasesContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.tableNameWithAliases`.
	 * @param ctx the parse tree
	 */
	exitTableNameWithAliases?: (ctx: TableNameWithAliasesContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	enterGrantor?: (ctx: GrantorContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.grantor`.
	 * @param ctx the parse tree
	 */
	exitGrantor?: (ctx: GrantorContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	enterPrincipal?: (ctx: PrincipalContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.principal`.
	 * @param ctx the parse tree
	 */
	exitPrincipal?: (ctx: PrincipalContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.roles`.
	 * @param ctx the parse tree
	 */
	enterRoles?: (ctx: RolesContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.roles`.
	 * @param ctx the parse tree
	 */
	exitRoles?: (ctx: RolesContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	enterIdentifier?: (ctx: IdentifierContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.identifier`.
	 * @param ctx the parse tree
	 */
	exitIdentifier?: (ctx: IdentifierContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	enterNumber?: (ctx: NumberContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.number`.
	 * @param ctx the parse tree
	 */
	exitNumber?: (ctx: NumberContext) => void;

	/**
	 * Enter a parse tree produced by `SqlBaseParser.nonReserved`.
	 * @param ctx the parse tree
	 */
	enterNonReserved?: (ctx: NonReservedContext) => void;
	/**
	 * Exit a parse tree produced by `SqlBaseParser.nonReserved`.
	 * @param ctx the parse tree
	 */
	exitNonReserved?: (ctx: NonReservedContext) => void;
}

